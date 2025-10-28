package com.awsft.knifeandmustache.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.awsft.knifeandmustache.model.Appointment;
import com.awsft.knifeandmustache.model.ServiceAppointment;


public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
     // retorna todos service_appointments do barber.id= i
    @Query(value = 
        "SELECT sa.* FROM appointments a " + 
        " JOIN service_appointments sa ON sa.appointment_id = a.id" + 
        " JOIN barbers b ON sa.barber_id = b.id" + 
        " WHERE sa.barber_id = :id", nativeQuery = true)
    List<ServiceAppointment> findBarbersAppointments(Long id);

     // retorna todos appointments de um dia appointments.appointment_time= dayOfWeek
    //  0 DIMINGO, 1 SEGUNDA, 2 TERÇA, ... 6 SÁBADO
    @Query(value = "SELECT * FROM appointments WHERE EXTRACT(DOW FROM appointment_time) = :dayOfWeek", nativeQuery = true)
    List<Appointment> findByDayOfWeek(@Param("dayOfWeek") Long dayOfWeek);
    
    // retorna todos service_appointments do barber.id = id e barber.barber_active = true
    // o segundo parametro é o dia
    @Query(value = 
        "SELECT sa.* FROM appointments a " + 
        " JOIN service_appointments sa ON sa.appointment_id = a.id" + 
        " JOIN barbers b ON sa.barber_id = b.id" + 
        " WHERE EXTRACT(DOW FROM appointment_time) = :dayOfWeek AND sa.barber_id = :id AND b.barber_active = TRUE", nativeQuery = true)
    List<ServiceAppointment> findServiceAppointmentsByBarberIdAndDayOfWeek(Long id, @Param("dayOfWeek") Long dayOfWeek);
} 

