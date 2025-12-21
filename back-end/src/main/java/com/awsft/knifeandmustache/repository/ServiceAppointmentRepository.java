package com.awsft.knifeandmustache.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.awsft.knifeandmustache.model.ServiceAppointment;
import java.util.List;


public interface ServiceAppointmentRepository extends JpaRepository<ServiceAppointment, Long>{
    
    List<ServiceAppointment> findByBarberId(Long id);

    @Query("""
        SELECT DISTINCT sa FROM ServiceAppointment sa
        JOIN sa.appointment a
        LEFT JOIN sa.barber b
        LEFT JOIN sa.service s
        WHERE a.barbershop.id = :id
    """)
    List<ServiceAppointment> findByBarbershopId(Long id);

    
} 

