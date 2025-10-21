package com.awsft.knifeandmustache.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.awsft.knifeandmustache.model.ServiceAppointments;
import java.util.List;


public interface ServiceAppointmentsRepository extends JpaRepository<ServiceAppointments, Long>{
    List<ServiceAppointments> findByBarbersId(Long id);
} 

