package com.awsft.knifeandmustache.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.awsft.knifeandmustache.dto.ServiceAppointmentDTO;
import com.awsft.knifeandmustache.model.ServiceAppointment;
import java.util.List;


public interface ServiceAppointmentRepository extends JpaRepository<ServiceAppointment, Long>{
    
    List<ServiceAppointment> findByBarberId(Long id);

    @Query("SELECT new com.awsft.knifeandmustache.dto.ServiceAppointmentDTO(a.appointmentStatus, sa.time, s.serviceDescription, s.serviceCategory, s.duration, s.value) " +  
        "FROM ServiceAppointment sa JOIN sa.barber b JOIN sa.service s JOIN sa.appointment a" + " WHERE b.barbershop.id = :id AND b.barberActive = TRUE")
    List<ServiceAppointmentDTO> findServiceAppointmentByBarbershopId(Long id);
} 

