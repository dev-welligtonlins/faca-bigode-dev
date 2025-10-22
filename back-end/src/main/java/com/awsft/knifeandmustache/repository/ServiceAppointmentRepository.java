package com.awsft.knifeandmustache.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.awsft.knifeandmustache.model.ServiceAppointment;
import java.util.List;


public interface ServiceAppointmentRepository extends JpaRepository<ServiceAppointment, Long>{
    
    List<ServiceAppointment> findByBarberId(Long id);
} 

