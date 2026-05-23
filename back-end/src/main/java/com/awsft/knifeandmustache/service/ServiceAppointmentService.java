package com.awsft.knifeandmustache.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.awsft.knifeandmustache.dto.ServiceAppointmentDTO;
import com.awsft.knifeandmustache.exception.custom.ConflictException;
import com.awsft.knifeandmustache.exception.custom.ForbiddenException;
import com.awsft.knifeandmustache.exception.custom.NotFoundException;
import com.awsft.knifeandmustache.model.Appointment;
import com.awsft.knifeandmustache.model.Barber;
import com.awsft.knifeandmustache.model.EAppointmentStatus;
import com.awsft.knifeandmustache.model.Service;
import com.awsft.knifeandmustache.model.ServiceAppointment;
import com.awsft.knifeandmustache.new_dto.NewServiceAppointmentDTO;
import com.awsft.knifeandmustache.repository.AppointmentRepository;
import com.awsft.knifeandmustache.repository.BarberRepository;
import com.awsft.knifeandmustache.repository.ServiceAppointmentRepository;
import com.awsft.knifeandmustache.repository.ServiceRepository;
import com.awsft.knifeandmustache.update_dto.UpdateServiceAppointmentDTO;

@org.springframework.stereotype.Service
public class ServiceAppointmentService {

    private final ServiceAppointmentRepository serviceAppointmentRepository;
    private final AppointmentRepository appointmentRepository;
    private final BarberRepository barberRepository;
    private final ServiceRepository serviceRepository;
  
    public ServiceAppointmentService(ServiceAppointmentRepository serviceAppointmentRepository, AppointmentRepository appointmentRepository, BarberRepository BarberRepository, ServiceRepository serviceRepository, BarberRepository barberRepository){
        this.serviceAppointmentRepository = serviceAppointmentRepository;
        this.appointmentRepository = appointmentRepository;
        this.serviceRepository = serviceRepository;
        this.barberRepository = barberRepository;
    }

    // retorna todos serviceAppointment da barbearia.id
    public List<ServiceAppointmentDTO> findByBarbershopId(Long barbershopId) {
        List<ServiceAppointment> serviceAppointments = serviceAppointmentRepository.findByBarbershopId(barbershopId);
        if(serviceAppointments.isEmpty()) {
            throw new NotFoundException("Barbearia não possui Atendimentos!");
        }
        return serviceAppointments.stream().map(ServiceAppointmentDTO::fromEntity).toList();
    }

    // retorna todos serviceAppointment da barbearia.id
    public List<ServiceAppointmentDTO> findByAppointmentId(Long barbershopId, Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() -> new NotFoundException("Atendimento não encontrado!"));
        if(appointment.getServiceAppointments().isEmpty()) {
            throw new NotFoundException("Atendimento não possui Service_appointment!");
        }
        if(!appointment.getBarbershop().getId().equals(barbershopId)) {
            throw new ForbiddenException("Atendimento não pertence à barbearia!");
        }
        
        return appointment.getServiceAppointments().stream().map(ServiceAppointmentDTO::fromEntity).toList();
    }

    // retorna um serviceAppointment pelo seu id
    public ServiceAppointmentDTO findById(Long barbershopId, Long serviceAppointmentId) {
        ServiceAppointment serviceAppointment = serviceAppointmentRepository.findById(serviceAppointmentId).orElseThrow(() -> new NotFoundException("Service_appointment não encontrado!"));
        if(!serviceAppointment.getAppointment().getId().equals(barbershopId)) {
            throw new ForbiddenException("Service_appointment não pertence à barbearia!");
        }
        return ServiceAppointmentDTO.fromEntity(serviceAppointment);
    }
    
    @Transactional
    public List<ServiceAppointmentDTO> createServiceAppointment(Long barbershopId, Long appointmentId, List<NewServiceAppointmentDTO> data){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() -> new NotFoundException("Atendimento não encontrado!"));
        if(!appointment.getBarbershop().getId().equals(barbershopId))
            throw new ForbiddenException("Atendimento não pertence à barbearia!");

        if(!appointment.getAppointmentStatus().equals(EAppointmentStatus.AGENDADO))
            throw new ConflictException("Não é possível alterar atendimento finalizado ou cancelado!");         

        List<ServiceAppointment> serviceAppointments = data.stream().map(obj -> {           
            ServiceAppointment serviceAppointment = new ServiceAppointment();
            serviceAppointment.setTime(obj.getTime());
            serviceAppointment.setAppointment(appointment);
            
            Barber barber = barberRepository.getReferenceById(obj.getBarberId());
            if(!barber.getBarbershop().getId().equals(barbershopId))
                throw new ForbiddenException("Barbeiro não pertence à barbearia!");
            serviceAppointment.setBarber(barber);

            Service service = serviceRepository.getReferenceById(obj.getServiceId());
            if(!service.getBarbershop().getId().equals(barbershopId))
                throw new ForbiddenException("Serviço não pertence à barbearia!");   
            serviceAppointment.setService(service);

            return serviceAppointment;  
        }).toList();
        
        serviceAppointments.forEach(appointment.getServiceAppointments()::add);

        BigDecimal totalValueAppointment = appointment.getServiceAppointments()
            .stream().map(sa -> sa.getService().getValue()).reduce(BigDecimal.ZERO, BigDecimal::add);
        appointment.setValue(totalValueAppointment);
        
        serviceAppointmentRepository.saveAll(serviceAppointments);
        return serviceAppointments.stream().map(ServiceAppointmentDTO::fromEntity).toList();
    }

    @Transactional
    public ServiceAppointmentDTO updateServiceAppointment(Long barbershopId, UpdateServiceAppointmentDTO data) {
        ServiceAppointment serviceAppointment = serviceAppointmentRepository.findById(data.getId())
            .orElseThrow(() -> new NotFoundException("Atendimento não encontrado!"));
        Appointment appointment = serviceAppointment.getAppointment();

        if(!appointment.getBarbershop().getId().equals(barbershopId))
            throw new ForbiddenException("Service_appointment não pertence ao atendimento!");
        
        if(!appointment.getAppointmentStatus().equals(EAppointmentStatus.AGENDADO))
            throw new ConflictException("Não é possível alterar atendimento cancelado ou finalizado");

        serviceAppointment.setTime(data.getTime());

        Barber barber = barberRepository.getReferenceById(data.getBarberId());
        if(!barber.getBarbershop().getId().equals(barbershopId))
            throw new ForbiddenException("Barbeiro não pertence à barbearia!");
        serviceAppointment.setBarber(barber);


        Service service = serviceRepository.getReferenceById(data.getServiceId());
         if(!service.getBarbershop().getId().equals(barbershopId))
            throw new ForbiddenException("Serviço não pertence à barbearia!");       
        serviceAppointment.setService(service);

        BigDecimal totalValueAppointment = appointment.getServiceAppointments()
            .stream().map(sa -> sa.getService().getValue()).reduce(BigDecimal.ZERO, BigDecimal::add);
        appointment.setValue(totalValueAppointment);

        return ServiceAppointmentDTO.fromEntity(serviceAppointment);
    }

    @Transactional
    public void deleteServiceAppointment(Long barbershopId, Long serviceAppointmentId){
        ServiceAppointment serviceAppointment = serviceAppointmentRepository.findById(serviceAppointmentId)
            .orElseThrow(() -> new NotFoundException("Service_appointment não encontrado!"));
        Appointment appointment = serviceAppointment.getAppointment();

        if(!appointment.getBarbershop().getId().equals(barbershopId))
            throw new ForbiddenException("Service_appointment não pertence ao atendimento!");
        
        if(!appointment.getAppointmentStatus().equals(EAppointmentStatus.AGENDADO))
            throw new ConflictException("Não é possível alterar atendimento finalizado ou cancelado!");

        serviceAppointment.setAppointment(null);
        appointment.getServiceAppointments().remove(serviceAppointment);

        
        BigDecimal totalValueAppointment = appointment.getServiceAppointments()
            .stream().map(sa -> sa.getService().getValue()).reduce(BigDecimal.ZERO, BigDecimal::add);
        appointment.setValue(totalValueAppointment);
    }   
}

