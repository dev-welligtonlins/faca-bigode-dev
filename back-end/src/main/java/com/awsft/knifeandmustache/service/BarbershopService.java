package com.awsft.knifeandmustache.service;

import java.util.List;

import com.awsft.knifeandmustache.model.Barbershop;
import com.awsft.knifeandmustache.repository.BarbershopRepository;

@org.springframework.stereotype.Service
public class BarbershopService implements ICrud<Barbershop>{

    private final BarbershopRepository repo;
  
    public BarbershopService(BarbershopRepository repo){
        this.repo = repo;
    }

    public Barbershop save(Barbershop obj){
        return repo.save(obj);
    }
 
    @Override
    public List<Barbershop> findAll(){
        return repo.findAll();
    }

    public Barbershop getById(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id){
        Barbershop obj = repo.findById(id).orElse(null);
        repo.delete(obj);
    }
}

