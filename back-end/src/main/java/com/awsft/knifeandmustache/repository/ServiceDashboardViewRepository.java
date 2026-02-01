package com.awsft.knifeandmustache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.awsft.knifeandmustache.view_dto.ServiceDashboardViewDTO;
import com.awsft.knifeandmustache.view_entity.ServiceDashboardView;

@Repository
public interface ServiceDashboardViewRepository extends JpaRepository<ServiceDashboardView, Long>{

    ServiceDashboardViewDTO findByBarbershopId(Long id);
} 

