package com.awsft.knifeandmustache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.awsft.knifeandmustache.view_dto.BarberDashboardViewDTO;
import com.awsft.knifeandmustache.view_entity.BarberDashboardView;

@Repository
public interface BarberDashboardViewRepository extends JpaRepository<BarberDashboardView, Long>{

    BarberDashboardViewDTO findByBarbershopId(Long id);
} 

