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

import com.awsft.knifeandmustache.model.Services;
import com.awsft.knifeandmustache.service.ServicesService;


@RestController
@RequestMapping("/service")
public class ServicesController implements  ICrud<Services>{
       
    private final ServicesService service;

    public ServicesController(ServicesService service){
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<Services> insert(@RequestBody Services obj){
        Services record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Services>> findAll(){
        List<Services> allRecors = service.findAll();
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Services> getById(@PathVariable("id") Long id){
        Services record = service.getById(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Services> update(@RequestBody Services obj){
        Services record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<List<Services>> getByServiceCategoryId(@PathVariable Long id) {
        List<Services> allRecors = service.getByServiceCategoryId(id);
        return new ResponseEntity<>(allRecors, HttpStatus.OK); 
    }
    
}
