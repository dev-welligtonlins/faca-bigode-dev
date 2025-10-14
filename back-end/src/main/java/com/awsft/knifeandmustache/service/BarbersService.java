package com.awsft.knifeandmustache.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.model.Barbers;
import com.awsft.knifeandmustache.repository.BarbersRepository;

@Service
public class BarbersService implements ICrud<Barbers>{

    private final BarbersRepository repo;
  
    public BarbersService(BarbersRepository repo){
        this.repo = repo;
    }

    public Barbers save(Barbers obj){
        return repo.save(obj);
    }
 
    @Override
    public List<Barbers> findAll(){
        return repo.findAll();
    }

    public Barbers getById(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id){
        Barbers obj = repo.findById(id).orElse(null);
        repo.delete(obj);
    }

    public List<Barbers> findByIsHairTrue() {
        return repo.findByIsHairTrue();
    }

    public List<Barbers> findByIsBeardTrue() {
        return repo.findByIsBeardTrue();
    }
}

