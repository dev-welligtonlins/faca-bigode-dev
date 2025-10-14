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

import com.awsft.knifeandmustache.model.Barbers;
import com.awsft.knifeandmustache.service.BarbersService;


@RestController
@RequestMapping("/barbers")
public class BarbersController implements  ICrud<Barbers>{
       
    private final BarbersService service;

    public BarbersController(BarbersService service){
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<Barbers> insert(@RequestBody Barbers obj){
        Barbers record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Barbers>> findAll(){
        List<Barbers> allRecors = service.findAll();
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barbers> getById(@PathVariable("id") Long id){
        Barbers record = service.getById(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Barbers> update(@RequestBody Barbers obj){
        Barbers record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/hair")
    public ResponseEntity<List<Barbers>> findByIsHairTrue(){
        List<Barbers> allRecors = service.findByIsHairTrue();
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/beard")
    public ResponseEntity<List<Barbers>> findByIsBeardTrue(){
        List<Barbers> allRecors = service.findByIsBeardTrue();
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }
    
}
