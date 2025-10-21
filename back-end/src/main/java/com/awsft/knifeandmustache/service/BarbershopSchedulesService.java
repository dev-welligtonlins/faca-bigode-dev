package com.awsft.knifeandmustache.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.model.BarbershopSchedules;
import com.awsft.knifeandmustache.repository.BarbershopSchedulesRepository;

@Service
public class BarbershopSchedulesService implements ICrud<BarbershopSchedules>{

    private final BarbershopSchedulesRepository repo;
  
    public BarbershopSchedulesService(BarbershopSchedulesRepository repo){
        this.repo = repo;
    }

    public BarbershopSchedules save(BarbershopSchedules obj){
        return repo.save(obj);
    }
 
    @Override
    public List<BarbershopSchedules> findAll(){
        return repo.findAll();
    }

    public BarbershopSchedules getById(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id){
        BarbershopSchedules obj = repo.findById(id).orElse(null);
        repo.delete(obj);
    }

}

