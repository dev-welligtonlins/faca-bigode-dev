package com.awsft.knifeandmustache.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ICrud<T> {
    public ResponseEntity<T> insert(T obj);
    
    public ResponseEntity<List<T>> findAll();

    public ResponseEntity<T> getById(Long id);

    // public ResponseEntity<T> update(T obj);

    public ResponseEntity<?> delete(Long id);

}
