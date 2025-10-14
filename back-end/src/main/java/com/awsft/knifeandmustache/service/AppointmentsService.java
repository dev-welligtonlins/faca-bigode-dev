package com.awsft.knifeandmustache.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.model.Appointments;
import com.awsft.knifeandmustache.repository.AppointmentsRepository;

@Service
public class AppointmentsService implements ICrud<Appointments>{

    private final AppointmentsRepository repo;
  
    public AppointmentsService(AppointmentsRepository repo){
        this.repo = repo;
    }

    public Appointments save(Appointments obj){
        return repo.save(obj);
    }
 
    @Override
    public List<Appointments> findAll(){
        return repo.findAll();
    }

    public Appointments getById(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id){
        Appointments obj = repo.findById(id).orElse(null);
        repo.delete(obj);
    }

}

