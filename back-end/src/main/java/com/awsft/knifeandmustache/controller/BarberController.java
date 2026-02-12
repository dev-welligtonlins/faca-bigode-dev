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
import com.awsft.knifeandmustache.service.BarberService;
import com.awsft.knifeandmustache.update_dto.UpdateBarberDTO;
import com.awsft.knifeandmustache.view_dto.BarberPageViewDTO;
import com.awsft.knifeandmustache.view_dto.ServicePageViewDTO;

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

    @GetMapping("/findall")
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

    // retorna todos barbeiros da barbeira.id
    @GetMapping("/dto/barbers/{id}")
    public ResponseEntity<List<BarberDTO>> findBarbersByBarbershopId(@PathVariable("id") Long id) {
        List<BarberDTO> allRecors = service.findBarbersByBarbershopId(id);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    
    @PostMapping("/dto/new-barber")
    public ResponseEntity<List<BarberDTO>> newDto(@RequestBody List<NewBarberDTO> listDto){
        List<BarberDTO> allRecord = service.newDto(listDto);
        return new ResponseEntity<>(allRecord, HttpStatus.CREATED);
    }

    @PutMapping("/dto/update-barber/{id}")
    public ResponseEntity<BarberDTO> updateDto(@PathVariable("id") Long id, @RequestBody UpdateBarberDTO obj){
        BarberDTO record = service.updateDto(id, obj);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    //(3)
    @Override
    @DeleteMapping("/dto/delete-barber/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //(5) retorna um barbeiro pelo barber.id
    @GetMapping("/dto/{id}")
    public ResponseEntity<BarberDTO> findIdDTO(@PathVariable("id") Long id) {
        BarberDTO record = service.findIdDTO(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    //(6) retorna todos barbeiros ativos da barbearia.id
    @GetMapping("/dto/barbershop/{id}")
    public ResponseEntity<List<BarberDTO>> findByBarbershopIdAndBarberActiveTrue(@PathVariable("id") Long id) {
        List<BarberDTO> allRecors = service.findByBarbershopIdAndBarberActiveTrue(id);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/page/{id}")
    public ResponseEntity<BarberPageViewDTO> servicePage(@PathVariable("id") Long id) {
        BarberPageViewDTO record = service.barberPage(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }    

}
