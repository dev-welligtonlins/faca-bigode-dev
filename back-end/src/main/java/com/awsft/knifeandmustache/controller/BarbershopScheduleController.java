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
import com.awsft.knifeandmustache.model.EDayWeek;
import com.awsft.knifeandmustache.new_dto.NewBarbershopScheduleDTO;
import com.awsft.knifeandmustache.service.BarbershopScheduleService;
import com.awsft.knifeandmustache.update_dto.UpdateBarbershopScheduleDTO;
import com.awsft.knifeandmustache.update_dto.UpdateServiceDTO;


@RestController
@RequestMapping("/barbershop_schedules")
public class BarbershopScheduleController {
       
    private final BarbershopScheduleService service;

    public BarbershopScheduleController(BarbershopScheduleService service){
        this.service = service;
    }


    @GetMapping("/findBarbershopSchedule/{barbershopId}/{eDayWeek}")
    public ResponseEntity<BarbershopScheduleDTO> findByDayWeekAndBarbershopId(@PathVariable("barbershopId") Long barbershopId, @PathVariable("eDayWeek") EDayWeek eDayWeek) {
        BarbershopScheduleDTO record = service.findByDayWeekAndBarbershopId(barbershopId, eDayWeek);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @GetMapping("/find/{barbershopId}")
    public ResponseEntity<List<BarbershopScheduleDTO>> findByBarbershopId(@PathVariable("barbershopId") Long barbershopId){
        List<BarbershopScheduleDTO> allRecors = service.findByBarbershopId(barbershopId);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @PostMapping("/create/{barbershopId}")
    public ResponseEntity<List<BarbershopScheduleDTO>> createBarbershopSchedule(@PathVariable("barbershopId") Long barbershopId, @RequestBody List<NewBarbershopScheduleDTO> data){
        List<BarbershopScheduleDTO> allRecors = service.createBarbershopSchedule(barbershopId ,data);
        return new ResponseEntity<>(allRecors, HttpStatus.CREATED);
    }

    @PutMapping("/update/{barbershopId}")
    public ResponseEntity<BarbershopScheduleDTO> updateBarbershopSchedule(@PathVariable("barbershopId") Long barbershopId, @RequestBody UpdateBarbershopScheduleDTO data){
        BarbershopScheduleDTO record = service.updateBarbershopSchedule(barbershopId, data);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{barbershopId}/{dayWeek}")
    public ResponseEntity<?> deleteBarbershopSchedule(@PathVariable("barbershopId") Long barbershopId, @PathVariable("dayWeek") EDayWeek dayWeek){
        service.deleteBarbershopSchedule(barbershopId, dayWeek);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
