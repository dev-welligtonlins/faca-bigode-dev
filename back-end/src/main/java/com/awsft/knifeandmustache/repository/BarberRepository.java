package com.awsft.knifeandmustache.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.awsft.knifeandmustache.model.Barber;
import java.util.List;


public interface BarberRepository extends JpaRepository<Barber, Long>{

    List<Barber> findByIsHairTrue();

    List<Barber> findByIsBeardTrue();
} 

