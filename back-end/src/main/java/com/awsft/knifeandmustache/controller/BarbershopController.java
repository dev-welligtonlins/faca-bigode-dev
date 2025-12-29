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
public class BarbershopController implements  ICrud<Barbershop>{
       
    private final BarbershopService service;

    public BarbershopController(BarbershopService service){
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<Barbershop> insert(@RequestBody Barbershop obj){
        Barbershop record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Barbershop>> findAll(){
        List<Barbershop> allRecors = service.findAll();
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barbershop> getById(@PathVariable("id") Long id){
        Barbershop record = service.getById(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Barbershop> update(@RequestBody Barbershop obj){
        Barbershop record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    //(5) retorna um barbeiro pelo barber.id
    @GetMapping("/dto/{id}")
    public ResponseEntity<BarbershopDTO> findIdDTO(@PathVariable("id") Long id) {
        BarbershopDTO record = service.findIdDTO(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    //(6) retorna todos barbeiros ativos da barbearia.id
    @GetMapping("/dto/")
    public ResponseEntity<List<BarbershopDTO>> findAllDTO() {
        List<BarbershopDTO> allRecors = service.findAllDTO();
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @PostMapping("/dto/new-barbershop/")
    public ResponseEntity<BarbershopDTO> newDto(@RequestBody NewBarbershopDTO dto){
        BarbershopDTO record = service.newDto(dto);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @PutMapping("/dto/update-barbershop/{id}")
    public ResponseEntity<BarbershopDTO> updateDto(@PathVariable("id") Long id, @RequestBody UpdateBarbershopDTO dto){
        BarbershopDTO record = service.updateDto(id, dto);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
}
