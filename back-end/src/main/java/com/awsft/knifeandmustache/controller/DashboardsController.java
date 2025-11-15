package com.awsft.knifeandmustache.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awsft.knifeandmustache.dto.BarberDashboardDTO;
import com.awsft.knifeandmustache.dto.ServiceDashboardDTO;
import com.awsft.knifeandmustache.service.BarberDashboardService;
import com.awsft.knifeandmustache.service.ServiceDashboardService;

@RestController
@RequestMapping("/dashboard")
public class DashboardsController {
       
    private final BarberDashboardService barberDashService;
    private final ServiceDashboardService serviceDashService;

    public DashboardsController(BarberDashboardService barberDashService, ServiceDashboardService serviceDashService){
        this.barberDashService = barberDashService;
        this.serviceDashService = serviceDashService;
    }

    @GetMapping("/dto/barber/{id}")
    public ResponseEntity<BarberDashboardDTO> findServiceAppointmentByBarbershop(@PathVariable("id") Long id) {
        BarberDashboardDTO record = barberDashService.getBarberDash(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @GetMapping("/dto/service/{id}")
    public ResponseEntity<ServiceDashboardDTO> findServiceByBarbershop(@PathVariable("id") Long id) {
        ServiceDashboardDTO record = serviceDashService.getServiceDash(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

}
