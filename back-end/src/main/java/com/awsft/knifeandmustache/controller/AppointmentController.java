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

import com.awsft.knifeandmustache.model.Appointment;
import com.awsft.knifeandmustache.model.ServiceAppointment;
import com.awsft.knifeandmustache.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController implements  ICrud<Appointment>{
       
    private final AppointmentService service;

    public AppointmentController(AppointmentService service){
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<Appointment> insert(@RequestBody Appointment obj){
        Appointment record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Appointment>> findAll(){
        List<Appointment> allRecors = service.findAll();
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getById(@PathVariable("id") Long id){
        Appointment record = service.getById(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Appointment> update(@RequestBody Appointment obj){
        Appointment record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/b/{id}")
    public ResponseEntity<List<ServiceAppointment>> findBarbersByAppointments(@PathVariable("id") Long id){
        List<ServiceAppointment> allRecors = service.findBarbersByAppointments(id);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

}
