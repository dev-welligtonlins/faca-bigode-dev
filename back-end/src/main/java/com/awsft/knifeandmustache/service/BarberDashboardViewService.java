package com.awsft.knifeandmustache.service;


import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.repository.BarberDashboardViewRepository;
import com.awsft.knifeandmustache.view_dto.BarberDashboardViewDTO;

@Service
public class BarberDashboardViewService {

    private final BarberDashboardViewRepository barberDashboardViewRepository;

    public BarberDashboardViewService(BarberDashboardViewRepository barberDashboardViewRepository) {
        this.barberDashboardViewRepository = barberDashboardViewRepository;
    }

    public BarberDashboardViewDTO findByBarbershopId(Long id) {
        return this.barberDashboardViewRepository.findByBarbershopId(id);
    }

}
