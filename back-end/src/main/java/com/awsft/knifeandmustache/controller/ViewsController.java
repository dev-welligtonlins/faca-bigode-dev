package com.awsft.knifeandmustache.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awsft.knifeandmustache.service.BarberDashboardViewService;
import com.awsft.knifeandmustache.service.ServiceDashboardViewService;
import com.awsft.knifeandmustache.service.ServiceListViewService;
import com.awsft.knifeandmustache.view_dto.BarberDashboardViewDTO;
import com.awsft.knifeandmustache.view_dto.ServiceDashboardViewDTO;
import com.awsft.knifeandmustache.view_dto.ServiceListViewDTO;

@RestController
@RequestMapping("/views")
public class ViewsController {
    // SERVIÇOS
    private final ServiceDashboardViewService serviceDashboardViewService;
    private final ServiceListViewService serviceListViewService;

    // BARBEIROS
    private final BarberDashboardViewService barberDashboardViewService;

    public ViewsController(
        ServiceDashboardViewService serviceDashboardViewService, ServiceListViewService serviceListViewService,
        BarberDashboardViewService barberDashboardViewService
    ){
        this.serviceDashboardViewService = serviceDashboardViewService;
        this.serviceListViewService = serviceListViewService;

        this.barberDashboardViewService = barberDashboardViewService;
    }

    // SERVIÇOS DASHBOARD
    @GetMapping("/dto/service-dashboard/{id}")
    public ResponseEntity<ServiceDashboardViewDTO> findServiceDashboardByBarbershopId(@PathVariable("id") Long id) {
        ServiceDashboardViewDTO record = serviceDashboardViewService.findByBarbershopId(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    // SERVIÇOS LISTA
    @GetMapping("/dto/service-list/{id}")
    public ResponseEntity<List<ServiceListViewDTO>> findServicesByBarbershopId(@PathVariable("id") Long id) {
        List<ServiceListViewDTO> records = serviceListViewService.findByBarbershopId(id);
        return new ResponseEntity<>(records, HttpStatus.OK);
    }


    // BARBEIROS DASHBOARD
    @GetMapping("/dto/barber-dashboard/{id}")
    public ResponseEntity<BarberDashboardViewDTO> findBarberDashboardByBarbershopId(@PathVariable("id") Long id) {
        BarberDashboardViewDTO record = barberDashboardViewService.findByBarbershopId(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

}
