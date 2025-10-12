package com.awsft.knifeandmustache.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awsft.knifeandmustache.model.ServiceCategories;

public interface ServiceCategoriesRepository extends JpaRepository<ServiceCategories, Long>{

    List<ServiceCategories> findAll();
} 

