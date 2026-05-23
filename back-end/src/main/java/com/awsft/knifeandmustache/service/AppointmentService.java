package com.awsft.knifeandmustache.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

import com.awsft.knifeandmustache.dto.AppointmentDTO;
import com.awsft.knifeandmustache.exception.custom.ConflictException;
import com.awsft.knifeandmustache.exception.custom.ForbiddenException;
import com.awsft.knifeandmustache.exception.custom.NotFoundException;
import com.awsft.knifeandmustache.model.Appointment;
import com.awsft.knifeandmustache.model.Barber;
import com.awsft.knifeandmustache.model.Barbershop;
import com.awsft.knifeandmustache.model.EAppointmentStatus;
import com.awsft.knifeandmustache.model.Payment;
import com.awsft.knifeandmustache.model.Service;
import com.awsft.knifeandmustache.model.ServiceAppointment;
import com.awsft.knifeandmustache.new_dto.NewAppointmentDTO;
import com.awsft.knifeandmustache.repository.AppointmentRepository;
import com.awsft.knifeandmustache.repository.BarberRepository;
import com.awsft.knifeandmustache.repository.BarbershopRepository;
import com.awsft.knifeandmustache.repository.ServiceRepository;
import com.awsft.knifeandmustache.update_dto.UpdateAppointmentDTO;

@org.springframework.stereotype.Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final BarberRepository barberRepository;
    private final ServiceRepository serviceRepository;
    private final BarbershopRepository barbershopRepository;

    public AppointmentService(AppointmentRepository appointmentRepository, BarberRepository barberRepository,
            ServiceRepository serviceRepository, BarbershopRepository barbershopRepository) {
        this.appointmentRepository = appointmentRepository;
        this.barberRepository = barberRepository;
        this.serviceRepository = serviceRepository;
        this.barbershopRepository = barbershopRepository;
    }

    // retorna todos atendimentos de barbearia.id
    public List<AppointmentDTO> findByBarbershopId(Long barbershopId) {
        List<Appointment> appointments = appointmentRepository.findByBarbershopId(barbershopId);
        if(appointments.isEmpty()) {
            throw new NotFoundException("Barbearia não possui Atendimentos!");
        }

        return appointments.stream().map(AppointmentDTO::fromEntity).toList();
    }

    // retorna um atendimento.id
    public AppointmentDTO findById(Long barbershopId, Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() -> new NotFoundException("Atendimento não encontrado!"));
        if(!appointment.getBarbershop().getId().equals(barbershopId)) {
            throw new ForbiddenException("Atendimento não pertence à barbearia!");
        }
        return AppointmentDTO.fromEntity(appointment);
    }

    @Transactional
    public AppointmentDTO createAppointment(Long barbershopId, NewAppointmentDTO data) {
        Barbershop barbershop = barbershopRepository.findById(barbershopId)
                                .orElseThrow(() -> new NotFoundException("Barbearia não encontrada!"));

        Appointment appointment = new Appointment();
        appointment.setClienteName(data.getClientName());
        appointment.setAppointmentTime(data.getAppointmentTime());
        appointment.setAppointmentStatus(EAppointmentStatus.AGENDADO);

        Set<ServiceAppointment> serviceAppointments = data.getServiceAppointments().stream().map(sa -> {
            ServiceAppointment serviceAppointment = new ServiceAppointment();
            serviceAppointment.setTime(sa.getTime());

            Barber barber = barberRepository.findById(sa.getBarberId()).orElseThrow(() -> new NotFoundException("Barbeiro não encontrado!"));
            if (!barber.getBarbershop().getId().equals(barbershopId))
                throw new ForbiddenException("Barbeiro não pertence à barbearia!");
            serviceAppointment.setBarber(barber);

            Service service = serviceRepository.findById(sa.getServiceId()).orElseThrow(() -> new NotFoundException("Serviço não encontrado!"));
            if (!service.getBarbershop().getId().equals(barbershopId))
                throw new ForbiddenException("Serviço não pertence à barbearia!");
            serviceAppointment.setService(service);

            serviceAppointment.setAppointment(appointment);
            appointment.getServiceAppointments().add(serviceAppointment);

            return serviceAppointment;
        }).collect(Collectors.toSet());

        Set<Payment> payments = data.getPayments().stream().map(p -> {
            Payment pay = new Payment();
            pay.setPaymentMethod(p.getPaymentMethod());
            pay.setPaymentStatus(p.getPaymentStatus());
            pay.setValue(0.0);

            pay.setAppointment(appointment);
            appointment.getPayments().add(pay);

            return pay;
        }).collect(Collectors.toSet());

        BigDecimal valueTotal = serviceAppointments.stream().map(sa -> sa.getService().getValue())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        appointment.setValue(valueTotal);
        appointment.setServiceAppointments(serviceAppointments);
        appointment.setPayments(payments);

        appointment.setBarbershop(barbershop);
        barbershop.getAppointments().add(appointment);

        appointmentRepository.save(appointment);

        return AppointmentDTO.fromEntity(appointment);
    }

    @Transactional
    public AppointmentDTO updateAppointment(Long barbershopId, UpdateAppointmentDTO data) {
        Appointment appointment = appointmentRepository.findById(data.getId())
                .orElseThrow(() -> new NotFoundException("Atendimento não encontrado!"));

        if (!appointment.getBarbershop().getId().equals(barbershopId))
            throw new ForbiddenException("Atendimento não pertence à barbearia!");

        if (!appointment.getAppointmentStatus().equals(EAppointmentStatus.AGENDADO))
            throw new ConflictException("Não é possível alterar atendimento finalizado ou cancelado!");

        appointment.setClienteName(data.getClientName());
        appointment.setAppointmentTime(data.getAppointmentTime());
        // o Map vai receber os pagamentos já registrados no atendimento
        // o id do pagamento diferente de nulo vai ser registrado em
        // existingPayments. Verifica riscos de id de outros atendimentos
        Map<Long, Payment> existingPayments = appointment.getPayments().stream()
                .filter(p -> p.getId() != null)
                .collect(Collectors.toMap(Payment::getId, Function.identity()));

        Set<Payment> payments = data.getPayments().stream()
                .map(p -> {

                    Payment payment = Optional.ofNullable(p.getId())
                            .map(existingPayments::get)
                            .orElseGet(() -> {
                                Payment newPay = new Payment();
                                newPay.setAppointment(appointment);
                                return newPay;
                            });

                    payment.setValue(p.getValue());
                    payment.setPaymentStatus(p.getPaymentStatus());
                    payment.setPaymentMethod(p.getPaymentMethod());

                    return payment;
                })
                .collect(Collectors.toSet());

        appointment.getPayments().clear();
        payments.forEach(appointment.getPayments()::add);

        Map<Long, ServiceAppointment> existingServiceAppointments = appointment.getServiceAppointments().stream()
                .filter(sa -> sa.getId() != null)
                .collect(Collectors.toMap(ServiceAppointment::getId, Function.identity()));

        Set<ServiceAppointment> serviceAppointments = data.getServiceAppointments().stream()
                .map(sa -> {

                    ServiceAppointment serviceAppointment = Optional.ofNullable(sa.getId())
                            .map(existingServiceAppointments::get)
                            .orElseGet(() -> {
                                ServiceAppointment s = new ServiceAppointment();
                                s.setAppointment(appointment);
                                return s;
                            });

                    serviceAppointment.setTime(sa.getTime());
                    Barber barber = barberRepository.findById(sa.getBarberId()).orElseThrow(() -> new NotFoundException("Barbeiro não encontrado!"));
                    if (!barber.getBarbershop().getId().equals(barbershopId))
                        throw new ForbiddenException("Barbeiro não pertence à barbearia!");
                    serviceAppointment.setBarber(barber);

                    Service service = serviceRepository.findById(sa.getServiceId()).orElseThrow(() -> new NotFoundException("Serviço não encontrado!"));
                    if (!service.getBarbershop().getId().equals(barbershopId))
                        throw new ForbiddenException("Serviço não pertence à barbearia!");
                    serviceAppointment.setService(service);

                    return serviceAppointment;
                })
                .collect(Collectors.toSet());

        appointment.getServiceAppointments().clear();
        serviceAppointments.forEach(appointment.getServiceAppointments()::add);
        // Percorre os serviços do atendimento e soma os valores
        BigDecimal valueTotal = appointment.getServiceAppointments().stream().map(sa -> sa.getService().getValue())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        appointment.setValue(valueTotal);

        appointmentRepository.flush();
        return AppointmentDTO.fromEntity(appointment);
    }

    @Transactional
    public void deleteAppointment(Long barbershopId, Long appointmentId ) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new NotFoundException("Atendimento não encontrado!"));

        if (!appointment.getBarbershop().getId().equals(barbershopId))
            throw new ForbiddenException("Atendimento não pertence à barbearia!");

        if (!appointment.getAppointmentStatus().equals(EAppointmentStatus.AGENDADO))
            throw new ConflictException("Não é possível alterar atendimento finalizado ou cancelado!");

        appointment.setAppointmentStatus(EAppointmentStatus.CANCELADO);

    }
}
