package com.awsft.knifeandmustache.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.repository.ServiceListViewRepository;
import com.awsft.knifeandmustache.view_dto.ServiceListViewDTO;

@Service
public class ServiceListViewService {

    private final ServiceListViewRepository serviceListViewRepository;

    public ServiceListViewService(ServiceListViewRepository serviceListViewRepository) {
        this.serviceListViewRepository = serviceListViewRepository;
    }

    public List<ServiceListViewDTO> findByBarbershopId(Long id) {
        return this.serviceListViewRepository.findByBarbershopId(id);
    }

}
