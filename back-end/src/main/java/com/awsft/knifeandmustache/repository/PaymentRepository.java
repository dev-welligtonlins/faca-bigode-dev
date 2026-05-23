package com.awsft.knifeandmustache.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awsft.knifeandmustache.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

    public List<Payment> findByAppointmentId(Long appointmentId);
} 

