package com.awsft.knifeandmustache.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awsft.knifeandmustache.model.Barbershop;
import com.awsft.knifeandmustache.service.BarbershopService;


@RestController
@RequestMapping("/barbershops")
public class BarbershopController implements  ICrud<Barbershop>{
       
    private final BarbershopService service;

    public BarbershopController(BarbershopService service){
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<Barbershop> insert(@RequestBody Barbershop obj){
        Barbershop record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Barbershop>> findAll(){
        List<Barbershop> allRecors = service.findAll();
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barbershop> getById(@PathVariable("id") Long id){
        Barbershop record = service.getById(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Barbershop> update(@RequestBody Barbershop obj){
        Barbershop record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
