package com.awsft.knifeandmustache.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.awsft.knifeandmustache.dto.AppointmentDTO;
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
import com.awsft.knifeandmustache.repository.ServiceRepository;
import com.awsft.knifeandmustache.update_dto.UpdateAppointmentDTO;


@org.springframework.stereotype.Service
public class AppointmentService implements ICrud<Appointment>{

    private final AppointmentRepository repo;
    private final BarberRepository repoBarber;
    private final ServiceRepository repoService;
    
    public AppointmentService(AppointmentRepository repo, BarberRepository repoBarber, ServiceRepository repoService){
        this.repo = repo;
        this.repoBarber = repoBarber;
        this.repoService = repoService;
    }

    public Appointment save(Appointment obj){
        return repo.save(obj);
    }
 
    @Override
    public List<Appointment> findAll(){
        return repo.findAll();
    }

    public Appointment getById(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id){
        Appointment obj = repo.findById(id).orElse(null);
        repo.delete(obj);
    }

    public List<ServiceAppointment> findBarbersByAppointments(Long id){
        return repo.findBarbersAppointments(id);
    }

    public List<Appointment> findByDayOfWeek(Long dayOfWeek) {
        return repo.findByDayOfWeek(dayOfWeek);
    }

    public List<ServiceAppointment> findServiceAppointmentsByBarberIdAndDayOfWeek(Long id, Long dayOfWeek){
        return repo.findServiceAppointmentsByBarberIdAndDayOfWeek(id, dayOfWeek);
    }

    //  retorna todos atendimentos de barbearia.id
    public List<AppointmentDTO> findByBarbershopId(Long id) {
        List<Appointment> list = repo.findByBarbershopId(id);

        return list.stream().map(AppointmentDTO::fromEntity).toList();
    }
    
    // retorna um atendimento.id
    public AppointmentDTO findIdDTO(Long id) {
        Appointment appointment = repo.findById(id).orElseThrow(() -> new RuntimeException("Atendimento não encontrado"));
        return AppointmentDTO.fromEntity(appointment);
    }

    // adiciona novo atendimento
    public AppointmentDTO newDto(NewAppointmentDTO dto){
        Appointment newObj = new Appointment();
        newObj.setClienteName(dto.getClientName());
        newObj.setAppointmentTime(dto.getAppointmentTime());
        newObj.setAppointmentStatus(EAppointmentStatus.AGENDADO);

        Set<ServiceAppointment> serviceAppointments = dto.getServiceAppointments().stream().map(sa -> {
            ServiceAppointment serviceAppointment = new ServiceAppointment();
            serviceAppointment.setAppointment(newObj);
            serviceAppointment.setTime(sa.getTime());

            Barber barber = repoBarber.getReferenceById(sa.getBarberId());  
            serviceAppointment.setBarber(barber);

            Service service = repoService.getReferenceById(sa.getServiceId());
            serviceAppointment.setService(service);

            return serviceAppointment;
        }).collect(Collectors.toSet());

        Set<Payment> payments = dto.getPayments().stream().map(p -> {
            Payment pay = new Payment();
            pay.setAppointment(newObj);
            pay.setPaymentMethod(p.getPaymentMethod());
            pay.setPaymentStatus(p.getPaymentStatus());
            pay.setValue(0.0);
            return pay;
        }).collect(Collectors.toSet());

        BigDecimal valueTotal = serviceAppointments.stream().map(sa -> sa.getService().getValue())
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        newObj.setValue(valueTotal);
        newObj.setServiceAppointments(serviceAppointments);
        newObj.setPayments(payments);

        Barbershop barbershop = new Barbershop();
        barbershop.setId(dto.getBarbershopId());
        newObj.setBarbershop(barbershop);

        repo.save(newObj);
        Appointment appointment = repo.findById(newObj.getId()).orElseThrow(() -> new RuntimeException("Appointment not found"));
        return AppointmentDTO.fromEntity(appointment);
    }

    public AppointmentDTO updateDto(Long id, UpdateAppointmentDTO dto) {
        Appointment updateObj = getById(id);
        updateObj.setClienteName(dto.getClientName());
        updateObj.setAppointmentTime(dto.getAppointmentTime());
        // o Map vai receber os pagamentos já registrados no atendimento 
        // o id do pagamento diferente de nulo vai ser registrado em
        // existingPayments. Verifica riscos de id de outros atendimentos
        Map<Long, Payment> existingPayments = updateObj.getPayments().stream()
            .filter(p -> p.getId() != null) 
            .collect(Collectors.toMap(Payment::getId, Function.identity()));

        Set<Payment> payments =
            dto.getPayments().stream()
                .map(p -> {

                    Payment payment =
                        Optional.ofNullable(p.getId())
                            .map(existingPayments::get)
                            .orElseGet(() -> {
                                Payment newPay = new Payment();
                                newPay.setAppointment(updateObj);
                                return newPay;
                            });

                    payment.setValue(p.getValue());
                    payment.setPaymentStatus(p.getPaymentStatus());
                    payment.setPaymentMethod(p.getPaymentMethod());

                    return payment;
                })
                .collect(Collectors.toSet());
        
        updateObj.getPayments().clear();
        payments.forEach(updateObj.getPayments()::add);

        Map<Long, ServiceAppointment> existingServiceAppointments =
            updateObj.getServiceAppointments().stream()
                .filter(sa -> sa.getId() != null)
                .collect(Collectors.toMap(ServiceAppointment::getId, Function.identity()));

        Set<ServiceAppointment> serviceAppointments =
            dto.getServiceAppointments().stream()
                .map(sa -> {

                    ServiceAppointment serviceAppointment =
                        Optional.ofNullable(sa.getId())
                            .map(existingServiceAppointments::get)
                            .orElseGet(() -> {
                                ServiceAppointment s = new ServiceAppointment();
                                s.setAppointment(updateObj);
                                return s;
                            });

                    serviceAppointment.setTime(sa.getTime());
                    serviceAppointment.setBarber(repoBarber.getReferenceById(sa.getBarberId()));
                    serviceAppointment.setService(repoService.getReferenceById(sa.getServiceId()));

                    return serviceAppointment;
                })
                .collect(Collectors.toSet());

        updateObj.getServiceAppointments().clear();
        serviceAppointments.forEach(updateObj.getServiceAppointments()::add);
        // Percorre os serviços do atendimento e soma os valores
        BigDecimal valueTotal = updateObj.getServiceAppointments().stream().map(sa -> sa.getService().getValue()).reduce(BigDecimal.ZERO, BigDecimal::add);
        updateObj.setValue(valueTotal);

        repo.save(updateObj);
        Appointment appointment = repo.findById(updateObj.getId()).orElseThrow(() -> new RuntimeException("Appointment not found"));
        return AppointmentDTO.fromEntity(appointment);
    }
}
