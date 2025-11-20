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
import com.awsft.knifeandmustache.model.Service;
import com.awsft.knifeandmustache.new_dto.NewServiceDTO;
import com.awsft.knifeandmustache.service.ServiceService;


@RestController
@RequestMapping("/services")
public class ServiceController implements  ICrud<Service>{
       
    private final ServiceService service;

    public ServiceController(ServiceService service){
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<Service> insert(@RequestBody Service obj){
        Service record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Service>> findAll(){
        List<Service> allRecors = service.findAll();
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Service> getById(@PathVariable("id") Long id){
        Service record = service.getById(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Service> update(@RequestBody Service obj){
        Service record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    // @Override
    // @DeleteMapping("/{id}")
    // public ResponseEntity<?> delete(@PathVariable("id") Long id){
    //     service.delete(id);
    //     return new ResponseEntity<>(HttpStatus.OK);
    // }
    

    @GetMapping("/barbershop/{id}")
    public ResponseEntity<List<Service>> findByBarbershopIdAndServiceActiveTrue(@PathVariable("id") Long id) {
        List<Service> allRecors = service.findByBarbershopIdAndServiceActiveTrue(id);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/dto/services/{id}")
    public ResponseEntity<List<ServiceDTO>> findServicesByBarbershopId(@PathVariable("id") Long id) {
        List<ServiceDTO> allRecors = service.findServicesByBarbershopId(id);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @PostMapping("/dto/new-service")
    public ResponseEntity<List<NewServiceDTO>> newDto(@RequestBody List<NewServiceDTO> listDto){
        List<NewServiceDTO> allRecord = service.newDto(listDto);
        return new ResponseEntity<>(allRecord, HttpStatus.CREATED);
    }

    @PutMapping("/dto/update-service/{id}")
    public ResponseEntity<ServiceDTO> updateDto(@PathVariable("id") Long id, @RequestBody ServiceDTO obj){
        ServiceDTO record = service.updateDto(id, obj);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/dto/delete-service/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
