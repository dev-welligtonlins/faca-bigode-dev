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

import com.awsft.knifeandmustache.model.ServiceAppointments;
import com.awsft.knifeandmustache.service.ServiceAppointmentsService;

@RestController
@RequestMapping("/service_appointments")
public class ServiceAppointmentsController implements  ICrud<ServiceAppointments>{
       
    private final ServiceAppointmentsService service;

    public ServiceAppointmentsController(ServiceAppointmentsService service){
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<ServiceAppointments> insert(@RequestBody ServiceAppointments obj){
        ServiceAppointments record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<ServiceAppointments>> findAll(){
        List<ServiceAppointments> allRecors = service.findAll();
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceAppointments> getById(@PathVariable("id") Long id){
        ServiceAppointments record = service.getById(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<ServiceAppointments> update(@RequestBody ServiceAppointments obj){
        ServiceAppointments record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/barber/{id}")
    public ResponseEntity<List<ServiceAppointments>> findByBarbersId(@PathVariable("id") Long id){
        List<ServiceAppointments> allRecors = service.findByBarbersId(id);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }
}
