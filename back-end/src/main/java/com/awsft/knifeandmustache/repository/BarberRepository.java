package com.awsft.knifeandmustache.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.awsft.knifeandmustache.model.Barber;

import java.util.List;


public interface BarberRepository extends JpaRepository<Barber, Long>{

    List<Barber> findByBarbershopIdAndBarberActiveTrueAndIsHairTrue(Long id);

    List<Barber> findByBarbershopIdAndBarberActiveTrueAndIsBeardTrue(Long id);

    // retorna todos barbeiros ativos da barbearia.id
    List<Barber> findByBarbershopIdAndBarberActiveTrue(Long id);

    List<Barber> findBarbersByBarbershopId(Long id);
    
} 

