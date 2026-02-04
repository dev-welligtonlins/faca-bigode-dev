package com.awsft.knifeandmustache.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.awsft.knifeandmustache.view_dto.ServiceListViewDTO;
import com.awsft.knifeandmustache.view_entity.ServiceListView;

@Repository
public interface ServiceListViewRepository extends JpaRepository<ServiceListView, Long>{

    List<ServiceListViewDTO> findByBarbershopId(Long id);
} 

