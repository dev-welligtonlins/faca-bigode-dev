package com.awsft.knifeandmustache.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.model.Accommodation;
import com.awsft.knifeandmustache.repository.AccommodationRepository;

@Service
public class AccommodationService implements ICrud<Accommodation>{

    private final AccommodationRepository repo;
  
    public AccommodationService(AccommodationRepository repo){
        this.repo = repo;
    }

    public Accommodation save(Accommodation obj){
        return repo.save(obj);
    }
 
    @Override
    public List<Accommodation> findAll(){
        return repo.findAll();
    }

    public Accommodation getById(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id){
        Accommodation obj = repo.findById(id).orElse(null);
        repo.delete(obj);
    }

}

