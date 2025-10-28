package com.awsft.knifeandmustache.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.model.Appointment;
import com.awsft.knifeandmustache.model.ServiceAppointment;
import com.awsft.knifeandmustache.repository.AppointmentRepository;

@Service
public class AppointmentService implements ICrud<Appointment>{

    private final AppointmentRepository repo;
    
    public AppointmentService(AppointmentRepository repo){
        this.repo = repo;
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
    
}

