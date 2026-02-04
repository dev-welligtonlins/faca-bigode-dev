package com.awsft.knifeandmustache.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awsft.knifeandmustache.dto.BarberDashboardDTO;
import com.awsft.knifeandmustache.service.ServiceDashboardViewService;
import com.awsft.knifeandmustache.service.ServiceListViewService;
import com.awsft.knifeandmustache.view_dto.ServiceDashboardViewDTO;
import com.awsft.knifeandmustache.view_dto.ServiceListViewDTO;

@RestController
@RequestMapping("/views")
public class ViewsController {
       
    private final ServiceDashboardViewService serviceDashboardViewService;
    private final ServiceListViewService serviceListViewService;
    // private final ServiceDashboardService serviceDashService;

    public ViewsController(ServiceDashboardViewService serviceDashboardViewService,
                            ServiceListViewService serviceListViewService
    ){
        this.serviceDashboardViewService = serviceDashboardViewService;
        this.serviceListViewService = serviceListViewService;
    }

    @GetMapping("/dto/service-dashboard/{id}")
    public ResponseEntity<ServiceDashboardViewDTO> findByBarbershopId(@PathVariable("id") Long id) {
        ServiceDashboardViewDTO record = serviceDashboardViewService.findByBarbershopId(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @GetMapping("/dto/service-list/{id}")
    public ResponseEntity<List<ServiceListViewDTO>> findServicesByBarbershopId(@PathVariable("id") Long id) {
        List<ServiceListViewDTO> records = serviceListViewService.findByBarbershopId(id);
        return new ResponseEntity<>(records, HttpStatus.OK);
    }
    // @GetMapping("/dto/service/{id}")
    // public ResponseEntity<ServiceDashboardDTO> findServiceByBarbershop(@PathVariable("id") Long id) {
    //     ServiceDashboardDTO record = serviceDashService.getServiceDash(id);
    //     return new ResponseEntity<>(record, HttpStatus.OK);
    // }

}
