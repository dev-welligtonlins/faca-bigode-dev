package com.awsft.knifeandmustache.service;

import java.util.List;

import com.awsft.knifeandmustache.dto.BarbershopDTO;
import com.awsft.knifeandmustache.model.Accommodation;
import com.awsft.knifeandmustache.model.Address;

public interface ICrud<T> {
    public T save(T object);

    public List<Address> findAll();

    public T getById(Long id);

    public void delete(Long id);
}


  

