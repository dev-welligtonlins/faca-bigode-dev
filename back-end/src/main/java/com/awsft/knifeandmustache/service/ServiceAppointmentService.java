package com.awsft.knifeandmustache.service;

import java.util.List;

import com.awsft.knifeandmustache.dto.ServiceAppointmentDTO;
import com.awsft.knifeandmustache.model.Appointment;
import com.awsft.knifeandmustache.model.Barber;
import com.awsft.knifeandmustache.model.Service;
import com.awsft.knifeandmustache.model.ServiceAppointment;
import com.awsft.knifeandmustache.new_dto.NewServiceAppointmentDTO;
import com.awsft.knifeandmustache.repository.ServiceAppointmentRepository;

@org.springframework.stereotype.Service
public class ServiceAppointmentService implements ICrud<ServiceAppointment>{

    private final ServiceAppointmentRepository repo;
  
    public ServiceAppointmentService(ServiceAppointmentRepository repo){
        this.repo = repo;
    }

    public ServiceAppointment save(ServiceAppointment obj){
        return repo.save(obj);
    }
 
    @Override
    public List<ServiceAppointment> findAll(){
        return repo.findAll();
    }

    public ServiceAppointment getById(Long id){
        return repo.findById(id).orElse(null);
    }

    public List<ServiceAppointment> findByBarberId(Long id){
        return repo.findByBarberId(id);
    }
    // retorna todos serviceAppointment da barbearia.id
    public List<ServiceAppointmentDTO> findByBarbershopId(Long id) {
        List<ServiceAppointment> list = repo.findByBarbershopId(id);
        return list.stream().map(ServiceAppointmentDTO::fromEntity).toList();
    }
    // retorna um serviceAppointment pelo seu id
    public ServiceAppointmentDTO findIdDTO(Long id) {
        ServiceAppointment serviceAppointment= repo.findById(id).orElseThrow(() -> new RuntimeException("ServiceAppointment não encontrado"));
        return ServiceAppointmentDTO.fromEntity(serviceAppointment);
    }
    // adiciona novos barbeiros
    public List<ServiceAppointmentDTO> newDto(List<NewServiceAppointmentDTO> listDto){
        List<ServiceAppointment> list = listDto.stream().map(obj -> {
            ServiceAppointment newObj = new ServiceAppointment();
            newObj.setTime(obj.getTime());
            
            Appointment appointment = new Appointment();
            appointment.setId(obj.getAppointmentId());
            newObj.setAppointment(appointment);
            
            Barber barber = new Barber();
            barber.setId(obj.getBarberId());
            newObj.setBarber(barber);
            
            Service service = new Service();
            service.setId(obj.getServiceId());
            newObj.setService(service);
            return newObj;  
        }).toList();

        repo.saveAll(list);
        return list.stream().map(ServiceAppointmentDTO::fromEntity).toList();
    }

    // precisa alterar para buscar o appointment.id e uma lista de newServiceAppointment
    public ServiceAppointmentDTO updateDto(Long id, NewServiceAppointmentDTO obj) {
        ServiceAppointment updateObj = getById(id);
        updateObj.setTime(obj.getTime());

        Barber barber = new Barber();
        barber.setId(obj.getBarberId());
        updateObj.setBarber(barber);

        Service service = new Service();
        service.setId(obj.getServiceId());
        updateObj.setService(service);

        repo.save(updateObj);
        return ServiceAppointmentDTO.fromEntity(updateObj);
    }

    @Override
    public void delete(Long id){
        ServiceAppointment obj = repo.findById(id).orElse(null);
        repo.delete(obj);
    }
}

