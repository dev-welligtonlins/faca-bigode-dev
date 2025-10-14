package com.awsft.knifeandmustache.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.model.PaymentMethods;
import com.awsft.knifeandmustache.model.Payments;
import com.awsft.knifeandmustache.repository.PaymentsRepository;

@Service
public class PaymentsService implements ICrud<Payments>{

    private final PaymentsRepository repo;
  
    public PaymentsService(PaymentsRepository repo){
        this.repo = repo;
    }

    public Payments save(Payments obj){
        return repo.save(obj);
    }
 
    @Override
    public List<Payments> findAll(){
        return repo.findAll();
    }

    public Payments getById(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id){
        Payments obj = repo.findById(id).orElse(null);
        repo.delete(obj);
    }

}

