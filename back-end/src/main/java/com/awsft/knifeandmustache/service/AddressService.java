package com.awsft.knifeandmustache.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.model.Address;
import com.awsft.knifeandmustache.repository.AddressRepository;

@Service
public class AddressService implements ICrud<Address>{

    private final AddressRepository repo;
  
    public AddressService(AddressRepository repo){
        this.repo = repo;
    }

    public Address save(Address obj){
        return repo.save(obj);
    }
 
    @Override
    public List<Address> findAll(){
        return repo.findAll();
    }

    public Address getById(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id){
        Address obj = repo.findById(id).orElse(null);
        repo.delete(obj);
    }

}

