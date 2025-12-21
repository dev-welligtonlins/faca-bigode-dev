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
public class AccommodationController implements  ICrud<Accommodation>{
       
    private final AccommodationService service;

    public AccommodationController(AccommodationService service){
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<Accommodation> insert(@RequestBody Accommodation obj){
        Accommodation record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Accommodation>> findAll(){
        List<Accommodation> allRecors = service.findAll();
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> getById(@PathVariable("id") Long id){
        Accommodation record = service.getById(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Accommodation> update(@RequestBody Accommodation obj){
        Accommodation record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<AccommodationDTO> findIdDTO(@PathVariable("id") Long id) {
        AccommodationDTO record = service.findIdDTO(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @GetMapping("/dto/barbershop/{id}")
    public ResponseEntity<List<AccommodationDTO>> findByBarbershopId(@PathVariable("id") Long id){
        List<AccommodationDTO> allRecors = service.findByBarbershopId(id);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @PostMapping("/dto/new-accommodation/")
    public ResponseEntity<AccommodationDTO> newDto(@RequestBody NewAccommodationDTO dto){
        AccommodationDTO record = service.newDto(dto);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @PutMapping("/dto/update-accommodation/{id}")
    public ResponseEntity<AccommodationDTO> updateDto(@PathVariable("id") Long id, @RequestBody UpdateAccommodationDTO dto){
        AccommodationDTO record = service.updateDto(id, dto);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
