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

import com.awsft.knifeandmustache.dto.ServiceDTO;
import com.awsft.knifeandmustache.new_dto.NewServiceDTO;
import com.awsft.knifeandmustache.service.ServiceService;
import com.awsft.knifeandmustache.update_dto.UpdateServiceDTO;
import com.awsft.knifeandmustache.view_dto.ServicePageViewDTO;


@RestController
@RequestMapping("/services")
public class ServiceController{
       
    private final ServiceService service;

    public ServiceController(ServiceService service){
        this.service = service;
    }

    @GetMapping("/findService/{barbershopId}/{serviceId}")
    public ResponseEntity<ServiceDTO> findById(@PathVariable("barbershopId") Long barbershopId, @PathVariable("serviceId") Long serviceId) {
        ServiceDTO record = service.findById(barbershopId, serviceId);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @GetMapping("/find/{barbershopId}")
    public ResponseEntity<List<ServiceDTO>> findByBarbershopIdAndServiceActiveTrue(@PathVariable("barbershopId") Long barbershopId) {
        List<ServiceDTO> allRecors = service.findByBarbershopIdAndServiceActiveTrue(barbershopId);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @PostMapping("/create/{barbershopId}")
    public ResponseEntity<List<ServiceDTO>> createService(@PathVariable("barbershopId") Long barbershopId, @RequestBody List<NewServiceDTO> data){
        List<ServiceDTO> allRecord = service.createService(barbershopId, data);
        return new ResponseEntity<>(allRecord, HttpStatus.CREATED);
    }

    @PutMapping("/update/{barbershopId}")
    public ResponseEntity<ServiceDTO> updateService(@PathVariable("barbershopId") Long barbershopId, @RequestBody UpdateServiceDTO data){
        ServiceDTO record = service.updateService(barbershopId, data);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{barbershopId}/{serviceId}")
    public ResponseEntity<?> deleteService(@PathVariable("barbershopId") Long barbershopId, @PathVariable("serviceId") Long serviceId){
        service.deleteService(barbershopId, serviceId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/page/{id}")
    public ResponseEntity<ServicePageViewDTO> servicePage(@PathVariable("id") Long id) {
        ServicePageViewDTO record = service.servicePage(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
}
