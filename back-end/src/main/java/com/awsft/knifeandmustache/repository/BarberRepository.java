package com.awsft.knifeandmustache.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.awsft.knifeandmustache.dto.BarberDTO;
import com.awsft.knifeandmustache.model.Barber;
import java.util.List;


public interface BarberRepository extends JpaRepository<Barber, Long>{
    // TODO: findByBarbershopIdAndBarberActiveTrueAndIsHairTrue [retorna os barbeiros q cortam cabelo, filtrando pelo id de barbershop]
    // TODO: findByBarbershopIdAndBarberActiveTrueAndIsBeardTrue [retorna os barbeiros q cortam barba, filtrando pelo id de barbershop]
    // TODO: findByBarbershopIdAndBarberActiveTrue [retorna todos os barbeiros qfiltrando pelo id de barbershop]


    List<Barber> findByBarbershopIdAndBarberActiveTrueAndIsHairTrue(Long id);

    List<Barber> findByBarbershopIdAndBarberActiveTrueAndIsBeardTrue(Long id);

    List<Barber> findByBarbershopIdAndBarberActiveTrue(Long id);

    @Query("SELECT new com.awsft.knifeandmustache.dto.BarberDTO(b.id, b.name, b.urlSocial, b.isHair, b.isBeard) " +  
            "FROM Barber b JOIN b.barbershop bs" + " WHERE bs.id = :id GROUP BY b.id, b.name, b.urlSocial, b.isHair, b.isBeard")
    List<BarberDTO> findBarbersByBarbershopId(Long id);
    
    // @Query("SELECT new com.awsft.knifeandmustache.dto.BarberServiceAppointmentDTO(b.name, COUNT(b)) " +  
    //     "FROM Barber b JOIN b.barbershop bs" + " WHERE bs.id = :id GROUP BY b.name, b.name")
    // BarberDashboardDTO findBarbersServiceAppointmentDTO(Long id);
} 

