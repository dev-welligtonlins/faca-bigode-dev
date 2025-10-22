package com.awsft.knifeandmustache.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awsft.knifeandmustache.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

} 

