package com.awsft.knifeandmustache.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.awsft.knifeandmustache.model.Services;

public interface ServicesRepository extends JpaRepository<Services, Long>{

    // List<Services> findAll();

    List<Services> getByServiceCategoryId(Long id);
} 

