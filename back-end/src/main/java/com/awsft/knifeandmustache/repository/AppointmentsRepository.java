package com.awsft.knifeandmustache.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.awsft.knifeandmustache.model.Appointments;

public interface AppointmentsRepository extends JpaRepository<Appointments, Long>{

} 

