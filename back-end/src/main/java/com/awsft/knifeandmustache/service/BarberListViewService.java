package com.awsft.knifeandmustache.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.repository.BarberListViewRepository;
import com.awsft.knifeandmustache.view_dto.BarberListViewDTO;

@Service
public class BarberListViewService {

    private final BarberListViewRepository barberListViewRepository;

    public BarberListViewService(BarberListViewRepository barberListViewRepository) {
        this.barberListViewRepository = barberListViewRepository;
    }

    public List<BarberListViewDTO> findByBarbershopId(Long id) {
        return this.barberListViewRepository.findByBarbershopId(id);
    }

}
