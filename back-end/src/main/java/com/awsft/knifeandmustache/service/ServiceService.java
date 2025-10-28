package com.awsft.knifeandmustache.service;

import java.util.List;

import com.awsft.knifeandmustache.model.Service;
import com.awsft.knifeandmustache.repository.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService implements ICrud<Service>{

    private final ServiceRepository repo;
  
    public ServiceService(ServiceRepository repo){
        this.repo = repo;
    }

    public Service save(Service obj){
        return repo.save(obj);
    }
 
    @Override
    public List<Service> findAll(){
        return repo.findAll();
    }

    public Service getById(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id){
        Service obj = repo.findById(id).orElse(null);
        obj.setServiceActive(false);
        repo.save(obj);
    }

    public List<Service> findByBarbershopIdAndServiceActiveTrue(Long id) {
        return repo.findByBarbershopIdAndServiceActiveTrue(id);
    }
}

