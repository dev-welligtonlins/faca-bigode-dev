package com.awsft.knifeandmustache.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.awsft.knifeandmustache.model.Appointment;
import com.awsft.knifeandmustache.model.ServiceAppointment;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // TODO: findBarbersAppointments [retorna todos service_appointments do barber.id= i]
    // TODO: findByDayOfWeek [retorna todos appointments de um dia appointments.appointment_time= dayOfWeek]
    // TODO: findServiceAppointmentsByBarberIdAndDayOfWeek [retorna todos service_appointments de um dia do barber.id = id e barber.barber_active = true
    //                                - dayOfWeek é o dia(id) dom=0 sab=6 ]
    
    @Query(value = 
        "SELECT sa.* FROM appointments a " + 
        " JOIN service_appointments sa ON sa.appointment_id = a.id" + 
        " JOIN barbers b ON sa.barber_id = b.id" + 
        " WHERE sa.barber_id = :id", nativeQuery = true)
    List<ServiceAppointment> findBarbersAppointments(@Param("id") Long id);

    @Query(value = "SELECT * FROM appointments WHERE EXTRACT(DOW FROM appointment_time) = :dayOfWeek", nativeQuery = true)
    List<Appointment> findByDayOfWeek(@Param("dayOfWeek") Long dayOfWeek);
    
    @Query(value = 
        "SELECT sa.* FROM appointments a " + 
        " JOIN service_appointments sa ON sa.appointment_id = a.id" + 
        " JOIN barbers b ON sa.barber_id = b.id" + 
        " WHERE EXTRACT(DOW FROM appointment_time) = :dayOfWeek AND sa.barber_id = :id AND b.barber_active = TRUE", nativeQuery = true)
    List<ServiceAppointment> findServiceAppointmentsByBarberIdAndDayOfWeek(Long id, @Param("dayOfWeek") Long dayOfWeek);

    // @Query("""
    //     SELECT DISTINCT a FROM Appointment a
    //     JOIN a.barbershop bs
    //     LEFT JOIN FETCH a.payments
    //     LEFT JOIN FETCH a.serviceAppointments
    //     WHERE bs.id = :id
    // """)
    List<Appointment> findByBarbershopId(Long id);

    // @Query("""
    //     SELECT DISTINCT a FROM Appointment a
    //     LEFT JOIN FETCH a.payments p
    //     LEFT JOIN FETCH a.serviceAppointments sa
    //     LEFT JOIN FETCH sa.barber b
    //     LEFT JOIN FETCH sa.service s
    //     WHERE a.id = :id
    // """)
    // Appointment findIdDTO(Long id);
} 

        

