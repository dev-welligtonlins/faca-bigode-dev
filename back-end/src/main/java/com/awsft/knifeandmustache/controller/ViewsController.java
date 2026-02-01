package com.awsft.knifeandmustache.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awsft.knifeandmustache.dto.BarberDashboardDTO;
import com.awsft.knifeandmustache.service.ServiceDashboardViewService;
import com.awsft.knifeandmustache.view_dto.ServiceDashboardViewDTO;

@RestController
@RequestMapping("/views")
public class ViewsController {
       
    private final ServiceDashboardViewService serviceDashboardViewService;
    // private final ServiceDashboardService serviceDashService;

    public ViewsController(ServiceDashboardViewService serviceDashboardViewService){
        this.serviceDashboardViewService = serviceDashboardViewService;
    }

    @GetMapping("/dto/service-dashboard/{id}")
    public ResponseEntity<ServiceDashboardViewDTO> findByBarbershopId(@PathVariable("id") Long id) {
        ServiceDashboardViewDTO record = serviceDashboardViewService.findByBarbershopId(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    // @GetMapping("/dto/service/{id}")
    // public ResponseEntity<ServiceDashboardDTO> findServiceByBarbershop(@PathVariable("id") Long id) {
    //     ServiceDashboardDTO record = serviceDashService.getServiceDash(id);
    //     return new ResponseEntity<>(record, HttpStatus.OK);
    // }

}
