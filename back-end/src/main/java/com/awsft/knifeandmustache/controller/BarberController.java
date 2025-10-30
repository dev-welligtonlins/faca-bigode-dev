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

import com.awsft.knifeandmustache.dto.BarberDTO;
import com.awsft.knifeandmustache.model.Barber;
import com.awsft.knifeandmustache.service.BarberService;



@RestController
@RequestMapping("/barbers")
public class BarberController implements  ICrud<Barber>{
       
    private final BarberService service;

    public BarberController(BarberService service){
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<Barber> insert(@RequestBody Barber obj){
        Barber record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Barber>> findAll(){
        List<Barber> allRecors = service.findAll();
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barber> getById(@PathVariable("id") Long id){
        Barber record = service.getById(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Barber> update(@RequestBody Barber obj){
        Barber record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/hair")
    public ResponseEntity<List<Barber>> findByBarbershopIdAndBarberActiveTrueAndIsHairTrue(@PathVariable("id") Long id){
        List<Barber> allRecors = service.findByBarbershopIdAndBarberActiveTrueAndIsHairTrue(id);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/{id}/beard")
    public ResponseEntity<List<Barber>> findByBarbershopIdAndBarberActiveTrueAndIsBeardTrue(@PathVariable("id") Long id){
        List<Barber> allRecors = service.findByBarbershopIdAndBarberActiveTrueAndIsBeardTrue(id);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/barbershop/{id}")
    public ResponseEntity<List<Barber>> findByBarbershopIdAndBarberActiveTrue(@PathVariable("id") Long id) {
        List<Barber> allRecors = service.findByBarbershopIdAndBarberActiveTrue(id);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }
    
    @GetMapping("/dto/{id}")
    public ResponseEntity<List<BarberDTO>> findBarbersByBarbershopId(@PathVariable("id") Long id) {
        List<BarberDTO> allRecors = service.findBarbersByBarbershopId(id);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

}
