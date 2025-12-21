package com.awsft.knifeandmustache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.awsft.knifeandmustache.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

    Address findByBarbershopId(Long id);
} 

