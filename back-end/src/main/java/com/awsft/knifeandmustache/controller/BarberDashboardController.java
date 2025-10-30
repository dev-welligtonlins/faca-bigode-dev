package com.awsft.knifeandmustache.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awsft.knifeandmustache.dto.BarberDashboardDTO;
import com.awsft.knifeandmustache.service.BarberDashboardService;

@RestController
@RequestMapping("/dashboard")
public class BarberDashboardController {
       
    private final BarberDashboardService service;

    public BarberDashboardController(BarberDashboardService service){
        this.service = service;
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<BarberDashboardDTO> findServiceAppointmentByBarbershop(@PathVariable("id") Long id) {
        BarberDashboardDTO record = service.getBarberDash(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
}
