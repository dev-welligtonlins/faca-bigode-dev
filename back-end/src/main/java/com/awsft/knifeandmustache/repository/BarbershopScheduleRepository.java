package com.awsft.knifeandmustache.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awsft.knifeandmustache.model.BarbershopSchedule;
import com.awsft.knifeandmustache.model.EDayWeek;

public interface BarbershopScheduleRepository extends JpaRepository<BarbershopSchedule, Long>{

    List<BarbershopSchedule> findByBarbershopId(Long id);

    Optional<BarbershopSchedule> findByDayWeekAndBarbershopId(EDayWeek dayWeek, Long barbershopId);
} 

