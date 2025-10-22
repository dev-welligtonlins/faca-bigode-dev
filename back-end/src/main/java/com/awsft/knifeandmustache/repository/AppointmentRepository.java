package com.awsft.knifeandmustache.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.awsft.knifeandmustache.model.Appointment;
import com.awsft.knifeandmustache.model.ServiceAppointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
    
    @Query(value = 
        "SELECT sa.* FROM appointments a " + 
        " JOIN service_appointments sa ON sa.appointment_id = a.id" + 
        " JOIN barbers b ON sa.barber_id = b.id" + 
        " WHERE sa.barber_id = :i", nativeQuery = true)
    List<ServiceAppointment> findBarbersAppointments(Long i);
} 

