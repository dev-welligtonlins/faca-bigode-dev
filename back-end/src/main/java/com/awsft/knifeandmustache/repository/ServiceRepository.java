package com.awsft.knifeandmustache.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.awsft.knifeandmustache.model.Service;

public interface ServiceRepository extends JpaRepository<Service, Long>{

    List<Service> findByBarbershopIdAndServiceActiveTrue(Long id);

    List<Service> findServicesByBarbershopIdAndServiceActiveTrue(Long id);
} 

