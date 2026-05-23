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

import com.awsft.knifeandmustache.dto.ServiceAppointmentDTO;
import com.awsft.knifeandmustache.new_dto.NewServiceAppointmentDTO;
import com.awsft.knifeandmustache.service.ServiceAppointmentService;
import com.awsft.knifeandmustache.update_dto.UpdateServiceAppointmentDTO;

@RestController
@RequestMapping("/service_appointments")
public class ServiceAppointmentController {
       
    private final ServiceAppointmentService service;

    public ServiceAppointmentController(ServiceAppointmentService service){
        this.service = service;
    }

    @GetMapping("/find/{appointmentId}")
    public ResponseEntity<List<ServiceAppointmentDTO>> findByappointmentId(@PathVariable("appointmentId") Long appointmentId){
        List<ServiceAppointmentDTO> allRecors = service.findByBarbershopId(appointmentId);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/find/{barbershopId}")
    public ResponseEntity<List<ServiceAppointmentDTO>> findByBarbershopId(@PathVariable("barbershopId") Long barbershopId){
        List<ServiceAppointmentDTO> allRecors = service.findByBarbershopId(barbershopId);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/findServiceAppointment/{barbershopId}/{serviceAppointmentId}")
    public ResponseEntity<ServiceAppointmentDTO> findById(@PathVariable("barbershopId") Long barbershopId, @PathVariable("serviceAppointmentId") Long serviceAppointmentId) {
        ServiceAppointmentDTO record = service.findById(barbershopId, serviceAppointmentId);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PostMapping("/create/{barbershopId}/{appointmentId}")
    public ResponseEntity<List<ServiceAppointmentDTO>> createServiceAppointment(@PathVariable("barbershopId") Long barbershopId, @PathVariable("appointmentId") Long appointmentId, @RequestBody List<NewServiceAppointmentDTO> data){
        List<ServiceAppointmentDTO> allRecord = service.createServiceAppointment(barbershopId, appointmentId, data);
        return new ResponseEntity<>(allRecord, HttpStatus.CREATED);
    }

    @PutMapping("/update/{barbershopId}")
    public ResponseEntity<ServiceAppointmentDTO> updateServiceAppointment(@PathVariable("barbershopId") Long barbershopId, @RequestBody UpdateServiceAppointmentDTO data){
        ServiceAppointmentDTO record = service.updateServiceAppointment(barbershopId, data);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{barbershopId}/{serviceAppointmentId}")
    public ResponseEntity<?> deleteServiceAppointment(@PathVariable("barbershopId") Long barbershopId, @PathVariable("serviceAppointmentId") Long serviceAppointmentId){
        service.deleteServiceAppointment(barbershopId, serviceAppointmentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
