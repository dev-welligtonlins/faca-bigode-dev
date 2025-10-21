package com.awsft.knifeandmustache.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.model.ServiceAppointments;
import com.awsft.knifeandmustache.repository.ServiceAppointmentsRepository;

@Service
public class ServiceAppointmentsService implements ICrud<ServiceAppointments>{

    private final ServiceAppointmentsRepository repo;
  
    public ServiceAppointmentsService(ServiceAppointmentsRepository repo){
        this.repo = repo;
    }

    public ServiceAppointments save(ServiceAppointments obj){
        return repo.save(obj);
    }
 
    @Override
    public List<ServiceAppointments> findAll(){
        return repo.findAll();
    }

    public ServiceAppointments getById(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id){
        ServiceAppointments obj = repo.findById(id).orElse(null);
        repo.delete(obj);
    }

    public List<ServiceAppointments> findByBarbersId(Long id){
        return repo.findByBarbersId(id);
    }

}

