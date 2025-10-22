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

import com.awsft.knifeandmustache.model.BarbershopSchedule;
import com.awsft.knifeandmustache.service.BarbershopScheduleService;


@RestController
@RequestMapping("/barbershop_schedules")
public class BarbershopScheduleController implements  ICrud<BarbershopSchedule>{
       
    private final BarbershopScheduleService service;

    public BarbershopScheduleController(BarbershopScheduleService service){
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<BarbershopSchedule> insert(@RequestBody BarbershopSchedule obj){
        BarbershopSchedule record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<BarbershopSchedule>> findAll(){
        List<BarbershopSchedule> allRecors = service.findAll();
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarbershopSchedule> getById(@PathVariable("id") Long id){
        BarbershopSchedule record = service.getById(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<BarbershopSchedule> update(@RequestBody BarbershopSchedule obj){
        BarbershopSchedule record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    
}
