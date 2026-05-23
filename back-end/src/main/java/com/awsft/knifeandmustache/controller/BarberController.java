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
import com.awsft.knifeandmustache.new_dto.NewBarberDTO;
import com.awsft.knifeandmustache.new_dto.NewServiceDTO;
import com.awsft.knifeandmustache.service.BarberService;
import com.awsft.knifeandmustache.update_dto.UpdateBarberDTO;
import com.awsft.knifeandmustache.view_dto.BarberPageViewDTO;
import com.awsft.knifeandmustache.view_dto.ServicePageViewDTO;

@RestController
@RequestMapping("/barbers")
public class BarberController{
       
    private final BarberService service;

    public BarberController(BarberService service){
        this.service = service;
    }

    // @GetMapping("/{id}/hair")
    // public ResponseEntity<List<Barber>> findByBarbershopIdAndBarberActiveTrueAndIsHairTrue(@PathVariable("id") Long id){
    //     List<Barber> allRecors = service.findByBarbershopIdAndBarberActiveTrueAndIsHairTrue(id);
    //     return new ResponseEntity<>(allRecors, HttpStatus.OK);
    // }

    // @GetMapping("/{id}/beard")
    // public ResponseEntity<List<Barber>> findByBarbershopIdAndBarberActiveTrueAndIsBeardTrue(@PathVariable("id") Long id){
    //     List<Barber> allRecors = service.findByBarbershopIdAndBarberActiveTrueAndIsBeardTrue(id);
    //     return new ResponseEntity<>(allRecors, HttpStatus.OK);
    // }



    //(5) retorna um barbeiro pelo barber.id
    @GetMapping("/findBarber/{barbershopId}/{barberId}")
    public ResponseEntity<BarberDTO> findById(@PathVariable("barbershopId") Long barbershopId, @PathVariable("barberId") Long barberId) {
        BarberDTO record = service.findById(barbershopId, barberId);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @GetMapping("/find/{barbershopId}")
    public ResponseEntity<List<BarberDTO>> findByBarbershopIdAndBarberActiveTrue(@PathVariable("barbershopId") Long barbershopId) {
        List<BarberDTO> allRecors = service.findByBarbershopIdAndBarberActiveTrue(barbershopId);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @PostMapping("/create/{barbershopId}")
    public ResponseEntity<List<BarberDTO>> createBarber(@PathVariable("barbershopId") Long barbershopId, @RequestBody List<NewBarberDTO> data){
        List<BarberDTO> allRecord = service.createBarber(barbershopId, data);
        return new ResponseEntity<>(allRecord, HttpStatus.CREATED);
    }  

    @PutMapping("/update/{barbershopId}")
    public ResponseEntity<BarberDTO> updateBarber(@PathVariable("barbershopId") Long barbershopId, @RequestBody UpdateBarberDTO data){
        BarberDTO record = service.updateBarber(barbershopId, data);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{barbershopId}/{barberId}")
    public ResponseEntity<?> deleteBarber(@PathVariable("barbershopId") Long barbershopId, @PathVariable("barberId") Long barberId){
        service.deleteBarber(barbershopId, barberId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/page/{id}")
    public ResponseEntity<BarberPageViewDTO> servicePage(@PathVariable("id") Long id) {
        BarberPageViewDTO record = service.barberPage(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }  
}
