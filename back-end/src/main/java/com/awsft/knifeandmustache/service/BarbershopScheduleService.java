package com.awsft.knifeandmustache.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.model.BarbershopSchedule;
import com.awsft.knifeandmustache.repository.BarbershopScheduleRepository;

@Service
public class BarbershopScheduleService implements ICrud<BarbershopSchedule>{

    private final BarbershopScheduleRepository repo;
  
    public BarbershopScheduleService(BarbershopScheduleRepository repo){
        this.repo = repo;
    }

    public BarbershopSchedule save(BarbershopSchedule obj){
        return repo.save(obj);
    }
 
    @Override
    public List<BarbershopSchedule> findAll(){
        return repo.findAll();
    }

    public BarbershopSchedule getById(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id){
        BarbershopSchedule obj = repo.findById(id).orElse(null);
        repo.delete(obj);
    }

}

