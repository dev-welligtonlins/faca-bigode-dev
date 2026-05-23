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

import com.awsft.knifeandmustache.dto.AccommodationDTO;
import com.awsft.knifeandmustache.model.Accommodation;
import com.awsft.knifeandmustache.new_dto.NewAccommodationDTO;
import com.awsft.knifeandmustache.service.AccommodationService;
import com.awsft.knifeandmustache.update_dto.UpdateAccommodationDTO;


@RestController
@RequestMapping("/accommodations")
public class AccommodationController {
       
    private final AccommodationService service;

    public AccommodationController(AccommodationService service){
        this.service = service;
    }

 

    @GetMapping("/find/{barberhopId}")
    public ResponseEntity<AccommodationDTO> findByBarbershopId(@PathVariable("barberhopId") Long barberhopId){
        AccommodationDTO record = service.findByBarbershopId(barberhopId);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PostMapping("/create/{barbershopId}")
    public ResponseEntity<AccommodationDTO> createAccommodation(@PathVariable("barbershopId") Long barbershopId, @RequestBody NewAccommodationDTO data){
        AccommodationDTO record = service.createAccommodation(barbershopId, data);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }
 
    @PutMapping("/update/{barbershopId}")
    public ResponseEntity<AccommodationDTO> updateAccommodation(@PathVariable("barbershopId") Long barbershopId, @RequestBody UpdateAccommodationDTO data){
        AccommodationDTO record = service.updateAccommodation(barbershopId, data);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{barbershopId}")
    public ResponseEntity<?> deleteAccommodation(@PathVariable("barbershopId") Long barbershopId){
        service.deleteAccommodation(barbershopId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
