package com.awsft.knifeandmustache.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.awsft.knifeandmustache.dto.BarbershopDTO;
import com.awsft.knifeandmustache.exception.custom.NotFoundException;
import com.awsft.knifeandmustache.model.Barbershop;
import com.awsft.knifeandmustache.new_dto.NewBarbershopDTO;
import com.awsft.knifeandmustache.repository.BarbershopRepository;
import com.awsft.knifeandmustache.update_dto.UpdateBarbershopDTO;

@org.springframework.stereotype.Service
public class BarbershopService{

    private final BarbershopRepository barbershopRepository;
  
    public BarbershopService(BarbershopRepository barbershopRepository){
        this.barbershopRepository = barbershopRepository;
    }

    // retorna um atendimento.id
    public BarbershopDTO findById(Long barbershopId) {
        Barbershop barbershop = barbershopRepository.findById(barbershopId).orElseThrow(() -> new NotFoundException("Barbearia não encontrada!"));
        return BarbershopDTO.fromEntity(barbershop);
    }

    // retorna todos atendimentos de barbearia.id
  
    public List<BarbershopDTO> findAll() {
        List<Barbershop> list = barbershopRepository.findAll();

        return list.stream().map(BarbershopDTO::fromEntity).toList();
    }
    @Transactional
    public BarbershopDTO createBarbershop(NewBarbershopDTO data){
        Barbershop barbershop = new Barbershop();
        barbershop.setName(data.getName());
        barbershopRepository.save(barbershop);
        return BarbershopDTO.fromEntity(barbershop);
    }
    @Transactional
    public BarbershopDTO updateBarbershop(Long barbershopId, UpdateBarbershopDTO data) {
        Barbershop updateBarbershop = barbershopRepository.findById(barbershopId).orElseThrow(() -> new NotFoundException("Barbearia não encontrada!"));
        updateBarbershop.setName(data.getName());
        
        return BarbershopDTO.fromEntity(updateBarbershop);
    }
    @Transactional
    public void deleteBarbershop(Long barbershopId) {
        Barbershop barbershop = barbershopRepository.findById(barbershopId).orElseThrow(() -> new NotFoundException("Barbearia não encontrada!"));
        barbershopRepository.delete(barbershop);
    }

}

