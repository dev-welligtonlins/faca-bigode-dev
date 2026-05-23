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

import com.awsft.knifeandmustache.dto.AddressDTO;
import com.awsft.knifeandmustache.model.Address;
import com.awsft.knifeandmustache.new_dto.NewAddressDTO;
import com.awsft.knifeandmustache.service.AddressService;
import com.awsft.knifeandmustache.update_dto.UpdateAddressDTO;


@RestController
@RequestMapping("/address")
public class AddressController {
       
    private final AddressService service;

    public AddressController(AddressService service){
        this.service = service;
    }

    @PostMapping("/create/{barbershopId}")
    public ResponseEntity<AddressDTO> createAdress(@PathVariable("barbershopId") Long barbershopId, @RequestBody NewAddressDTO data){
        AddressDTO record = service.createAdress(barbershopId, data);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @GetMapping("/find/{barbershopId}")
    public ResponseEntity<AddressDTO> findByBarbershopId(@PathVariable("barbershopId") Long barbershopId) {
        AddressDTO record = service.findByBarbershopId(barbershopId);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PutMapping("/update/{barbershopId}")
    public ResponseEntity<AddressDTO> updateAdress(@PathVariable("barbershopId") Long barbershopId, @RequestBody UpdateAddressDTO data){
        AddressDTO record = service.updateAdress(barbershopId, data);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{barbershopId}")
    public ResponseEntity<?> deleteAdress(@PathVariable("barbershopId") Long barbershopId){
        service.deleteAdress(barbershopId);
        return new ResponseEntity<>(HttpStatus.OK);
    }    
}
