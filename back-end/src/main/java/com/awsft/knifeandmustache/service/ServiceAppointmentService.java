package com.awsft.knifeandmustache.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.model.ServiceAppointment;
import com.awsft.knifeandmustache.repository.ServiceAppointmentRepository;

@Service
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

    @Override
    public void delete(Long id){
        ServiceAppointment obj = repo.findById(id).orElse(null);
        repo.delete(obj);
    }

    public List<ServiceAppointment> findByBarberId(Long id){
        return repo.findByBarberId(id);
    }

}

