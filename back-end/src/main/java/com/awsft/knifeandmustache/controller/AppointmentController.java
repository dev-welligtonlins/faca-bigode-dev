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

import com.awsft.knifeandmustache.dto.AppointmentDTO;
import com.awsft.knifeandmustache.new_dto.NewAppointmentDTO;
import com.awsft.knifeandmustache.service.AppointmentService;
import com.awsft.knifeandmustache.update_dto.UpdateAppointmentDTO;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
       
    private final AppointmentService service;

    public AppointmentController(AppointmentService service){
        this.service = service;
    }

    @GetMapping("/findAppointment/{barbershopId}/{AppointmentId}")
    public ResponseEntity<AppointmentDTO> findById(@PathVariable("barbershopId") Long barbershopId, @PathVariable("AppointmentId") Long appointmentId) {
        AppointmentDTO record = service.findById(barbershopId, appointmentId);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @GetMapping("/find/{barbershopId}")
    public ResponseEntity<List<AppointmentDTO>> findByBarbershopId(@PathVariable("barbershopId") Long barbershopId){
        List<AppointmentDTO> allRecors = service.findByBarbershopId(barbershopId);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @PostMapping("/create/{barbershopId}")
    public ResponseEntity<AppointmentDTO> createAppointment(@PathVariable("barbershopId") Long barbershopId, @RequestBody NewAppointmentDTO data){
        AppointmentDTO record = service.createAppointment(barbershopId, data);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @PutMapping("/update/{barbershopId}")
    public ResponseEntity<AppointmentDTO> updateAppointment(@PathVariable("barbershopId") Long barbershopId, @RequestBody UpdateAppointmentDTO data){
        AppointmentDTO record = service.updateAppointment(barbershopId, data);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    
    @DeleteMapping("/delete/{barbershopId}/{appointmentId}")
    public ResponseEntity<?> deleteAppointment(@PathVariable("barbershopId") Long barbershopId, @PathVariable("appointmentId") Long appointmentId){
        service.deleteAppointment(barbershopId, appointmentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
