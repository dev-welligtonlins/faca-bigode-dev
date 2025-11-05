package com.awsft.knifeandmustache.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.awsft.knifeandmustache.dto.BarberDTO;
import com.awsft.knifeandmustache.dto.ServiceDTO;
import com.awsft.knifeandmustache.model.Service;

public interface ServiceRepository extends JpaRepository<Service, Long>{

    List<Service> findByBarbershopIdAndServiceActiveTrue(Long id);

    @Query("SELECT new com.awsft.knifeandmustache.dto.ServiceDTO(s.serviceDescription, s.duration, s.value, s.serviceCategory) " +  
        "FROM Service s JOIN s.barbershop bs" + " WHERE s.serviceActive = true AND bs.id = :id GROUP BY s.serviceDescription, s.duration, s.value, s.serviceCategory")
    List<ServiceDTO> findServicesByBarbershopId(Long id);
} 

