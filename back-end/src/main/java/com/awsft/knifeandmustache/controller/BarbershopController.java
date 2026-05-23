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

import com.awsft.knifeandmustache.dto.BarbershopDTO;
import com.awsft.knifeandmustache.model.Barbershop;
import com.awsft.knifeandmustache.new_dto.NewBarbershopDTO;
import com.awsft.knifeandmustache.service.BarbershopService;
import com.awsft.knifeandmustache.update_dto.UpdateBarbershopDTO;


@RestController
@RequestMapping("/barbershops")
public class BarbershopController{
       
    private final BarbershopService service;

    public BarbershopController(BarbershopService service){
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<BarbershopDTO> createBarbershop(@RequestBody NewBarbershopDTO data){
        BarbershopDTO record = service.createBarbershop(data);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }
    
    @GetMapping("/find/{barbershopId}")
    public ResponseEntity<BarbershopDTO> findById(@PathVariable("barbershopId") Long barbershopId) {
        BarbershopDTO record = service.findById(barbershopId);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<BarbershopDTO>> findAll() {
        List<BarbershopDTO> allRecors = service.findAll();
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<BarbershopDTO> updateBarbershop(@RequestBody UpdateBarbershopDTO data){
        BarbershopDTO record = service.updateBarbershop(data.getId(), data);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{barbershopId}")
    public ResponseEntity<?> deleteBarbershop(@PathVariable("barbershopId") Long barbershopId){
        service.deleteBarbershop(barbershopId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
