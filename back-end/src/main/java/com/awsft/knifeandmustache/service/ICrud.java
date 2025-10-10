package com.awsft.knifeandmustache.service;

import java.util.List;

public interface ICrud<T> {
    public T save(T object);

    public List<T> findAll();

    public T getById(Long id);

    public void delete(Long id);
}


  

