package com.awsft.knifeandmustache.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.awsft.knifeandmustache.view_dto.BarberListViewDTO;
import com.awsft.knifeandmustache.view_entity.BarberListView;

@Repository
public interface BarberListViewRepository extends JpaRepository<BarberListView, Long>{

    List<BarberListViewDTO> findByBarbershopId(Long id);
} 

