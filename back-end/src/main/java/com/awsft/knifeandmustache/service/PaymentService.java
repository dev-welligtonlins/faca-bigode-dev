package com.awsft.knifeandmustache.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.model.Payment;
import com.awsft.knifeandmustache.repository.PaymentRepository;

@Service
public class PaymentService implements ICrud<Payment>{

    private final PaymentRepository repo;
  
    public PaymentService(PaymentRepository repo){
        this.repo = repo;
    }

    public Payment save(Payment obj){
        return repo.save(obj);
    }
 
    @Override
    public List<Payment> findAll(){
        return repo.findAll();
    }

    public Payment getById(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id){
        Payment obj = repo.findById(id).orElse(null);
        repo.delete(obj);
    }

}

