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

import com.awsft.knifeandmustache.dto.BarbershopScheduleDTO;
import com.awsft.knifeandmustache.model.BarbershopSchedule;
import com.awsft.knifeandmustache.new_dto.NewBarbershopScheduleDTO;
import com.awsft.knifeandmustache.service.BarbershopScheduleService;
import com.awsft.knifeandmustache.update_dto.UpdateBarbershopScheduleDTO;


@RestController
@RequestMapping("/barbershop_schedules")
public class BarbershopScheduleController implements  ICrud<BarbershopSchedule>{
       
    private final BarbershopScheduleService service;

    public BarbershopScheduleController(BarbershopScheduleService service){
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<BarbershopSchedule> insert(@RequestBody BarbershopSchedule obj){
        BarbershopSchedule record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<BarbershopSchedule>> findAll(){
        List<BarbershopSchedule> allRecors = service.findAll();
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarbershopSchedule> getById(@PathVariable("id") Long id){
        BarbershopSchedule record = service.getById(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<BarbershopSchedule> update(@RequestBody BarbershopSchedule obj){
        BarbershopSchedule record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<BarbershopScheduleDTO> findIdDTO(@PathVariable("id") Long id) {
        BarbershopScheduleDTO record = service.findIdDTO(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @GetMapping("/dto/barbershop/{id}")
    public ResponseEntity<List<BarbershopScheduleDTO>> findByBarbershopId(@PathVariable("id") Long id){
        List<BarbershopScheduleDTO> allRecors = service.findByBarbershopId(id);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @PostMapping("/dto/new-barbershop_schedule/")
    public ResponseEntity<List<BarbershopScheduleDTO>> newDto(@RequestBody List<NewBarbershopScheduleDTO> dto){
        List<BarbershopScheduleDTO> allRecors = service.newDto(dto);
        return new ResponseEntity<>(allRecors, HttpStatus.CREATED);
    }

    @PutMapping("/dto/update-barbershop_schedule/{id}")
    public ResponseEntity<BarbershopScheduleDTO> updateDto(@PathVariable("id") Long id, @RequestBody UpdateBarbershopScheduleDTO dto){
        BarbershopScheduleDTO record = service.updateDto(id, dto);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
