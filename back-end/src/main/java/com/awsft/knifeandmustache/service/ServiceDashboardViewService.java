package com.awsft.knifeandmustache.service;


import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.repository.ServiceDashboardViewRepository;
import com.awsft.knifeandmustache.view_dto.ServiceDashboardViewDTO;

@Service
public class ServiceDashboardViewService {

    private final ServiceDashboardViewRepository serviceDashboardViewRepository;

    public ServiceDashboardViewService(ServiceDashboardViewRepository serviceDashboardViewRepository) {
        this.serviceDashboardViewRepository = serviceDashboardViewRepository;
    }

    public ServiceDashboardViewDTO findByBarbershopId(Long id) {
        return this.serviceDashboardViewRepository.findByBarbershopId(id);
    }

}
