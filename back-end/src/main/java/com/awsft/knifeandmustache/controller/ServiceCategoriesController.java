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

import com.awsft.knifeandmustache.model.ServiceCategories;
import com.awsft.knifeandmustache.service.ServiceCategoriesService;

@RestController
@RequestMapping("/servicecategories")
public class ServiceCategoriesController implements  ICrud<ServiceCategories>{
       
    private final ServiceCategoriesService service;

    public ServiceCategoriesController(ServiceCategoriesService service){
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<ServiceCategories> insert(@RequestBody ServiceCategories obj){
        ServiceCategories record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<ServiceCategories>> findAll(){
        List<ServiceCategories> allRecors = service.findAll();
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceCategories> getById(@PathVariable("id") Long id){
        ServiceCategories record = service.getById(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<ServiceCategories> update(@RequestBody ServiceCategories obj){
        ServiceCategories record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
