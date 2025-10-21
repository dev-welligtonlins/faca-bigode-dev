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

import com.awsft.knifeandmustache.model.BarbershopSchedules;
import com.awsft.knifeandmustache.service.BarbershopSchedulesService;


@RestController
@RequestMapping("/barbershop_schedules")
public class BarbershopSchedulesController implements  ICrud<BarbershopSchedules>{
       
    private final BarbershopSchedulesService service;

    public BarbershopSchedulesController(BarbershopSchedulesService service){
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<BarbershopSchedules> insert(@RequestBody BarbershopSchedules obj){
        BarbershopSchedules record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<BarbershopSchedules>> findAll(){
        List<BarbershopSchedules> allRecors = service.findAll();
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarbershopSchedules> getById(@PathVariable("id") Long id){
        BarbershopSchedules record = service.getById(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<BarbershopSchedules> update(@RequestBody BarbershopSchedules obj){
        BarbershopSchedules record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    
}
