package com.awsft.knifeandmustache.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awsft.knifeandmustache.model.Accommodation;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long>{
    
    Optional<Accommodation> findByBarbershopId(Long barbershopId);
} 

