package com.awsft.knifeandmustache.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.awsft.knifeandmustache.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

    Optional<Address> findByBarbershopId(Long id);
} 

