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
import com.awsft.knifeandmustache.model.ServiceAppointment;
import com.awsft.knifeandmustache.new_dto.NewServiceAppointmentDTO;
import com.awsft.knifeandmustache.service.ServiceAppointmentService;

@RestController
@RequestMapping("/service_appointments")
public class ServiceAppointmentController implements  ICrud<ServiceAppointment>{
       
    private final ServiceAppointmentService service;

    public ServiceAppointmentController(ServiceAppointmentService service){
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<ServiceAppointment> insert(@RequestBody ServiceAppointment obj){
        ServiceAppointment record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<ServiceAppointment>> findAll(){
        List<ServiceAppointment> allRecors = service.findAll();
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceAppointment> getById(@PathVariable("id") Long id){
        ServiceAppointment record = service.getById(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<ServiceAppointment> update(@RequestBody ServiceAppointment obj){
        ServiceAppointment record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    
    @GetMapping("/barber/{id}")
    public ResponseEntity<List<ServiceAppointment>> findByBarberId(@PathVariable("id") Long id){
        List<ServiceAppointment> allRecors = service.findByBarberId(id);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/dto/barbershop/{id}")
    public ResponseEntity<List<ServiceAppointmentDTO>> findByBarbershopId(@PathVariable("id") Long id){
        List<ServiceAppointmentDTO> allRecors = service.findByBarbershopId(id);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<ServiceAppointmentDTO> findIdDTO(@PathVariable("id") Long id) {
        ServiceAppointmentDTO record = service.findIdDTO(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PostMapping("/dto/new-service_appointment/")
    public ResponseEntity<List<ServiceAppointmentDTO>> newDto(@RequestBody List<NewServiceAppointmentDTO> listDto){
        List<ServiceAppointmentDTO> allRecord = service.newDto(listDto);
        return new ResponseEntity<>(allRecord, HttpStatus.CREATED);
    }

    @PutMapping("/dto/update-service_appointment/{id}")
    public ResponseEntity<ServiceAppointmentDTO> updateDto(@PathVariable("id") Long id, @RequestBody NewServiceAppointmentDTO obj){
        ServiceAppointmentDTO record = service.updateDto(id, obj);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
