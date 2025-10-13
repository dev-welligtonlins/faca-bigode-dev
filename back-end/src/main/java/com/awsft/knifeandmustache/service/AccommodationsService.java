package com.awsft.knifeandmustache.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.model.Accommodations;
import com.awsft.knifeandmustache.repository.AccommodationsRepository;

@Service
public class AccommodationsService implements ICrud<Accommodations>{

    private final AccommodationsRepository repo;
  
    public AccommodationsService(AccommodationsRepository repo){
        this.repo = repo;
    }

    public Accommodations save(Accommodations obj){
        return repo.save(obj);
    }
 
    @Override
    public List<Accommodations> findAll(){
        return repo.findAll();
    }

    public Accommodations getById(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id){
        Accommodations obj = repo.findById(id).orElse(null);
        repo.delete(obj);
    }

}

