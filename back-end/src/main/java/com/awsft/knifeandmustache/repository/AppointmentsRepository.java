package com.awsft.knifeandmustache.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.awsft.knifeandmustache.model.Appointments;

public interface AppointmentsRepository extends JpaRepository<Appointments, Long>{
    
    @Query(value = 
        "SELECT a.* FROM service_appointments sa " + 
        " JOIN appointments a ON sa.appointment_id = a.id" + 
        " JOIN barbers b ON sa.barber_id = b.id" + 
        " WHERE sa.barber_id = :i", nativeQuery = true)
    List<Appointments> findBarbersAppointments(Long i);
} 

