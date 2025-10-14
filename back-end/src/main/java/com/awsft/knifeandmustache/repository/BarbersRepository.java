package com.awsft.knifeandmustache.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.awsft.knifeandmustache.model.Barbers;
import java.util.List;


public interface BarbersRepository extends JpaRepository<Barbers, Long>{

    List<Barbers> findByIsHairTrue();

    List<Barbers> findByIsBeardTrue();
} 

