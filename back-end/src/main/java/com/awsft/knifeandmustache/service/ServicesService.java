package com.awsft.knifeandmustache.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.model.Services;
import com.awsft.knifeandmustache.repository.ServicesRepository;

@Service
public class ServicesService implements ICrud<Services>{

    private final ServicesRepository repo;
  
    public ServicesService(ServicesRepository repo){
        this.repo = repo;
    }

    public Services save(Services obj){
        return repo.save(obj);
    }
 
    @Override
    public List<Services> findAll(){
        return repo.findAll();
    }

    public Services getById(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id){
        Services obj = repo.findById(id).orElse(null);
        repo.delete(obj);
    }

    public List<Services> getByServiceCategoryId(Long id) {
        return repo.getByServiceCategoryId(id);
    }
}

