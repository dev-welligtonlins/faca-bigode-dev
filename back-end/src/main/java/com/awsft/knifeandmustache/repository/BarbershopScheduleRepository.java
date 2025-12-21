package com.awsft.knifeandmustache.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awsft.knifeandmustache.model.BarbershopSchedule;

public interface BarbershopScheduleRepository extends JpaRepository<BarbershopSchedule, Long>{

    List<BarbershopSchedule> findByBarbershopId(Long id);
} 

