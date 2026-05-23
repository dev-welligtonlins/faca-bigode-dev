package com.awsft.knifeandmustache.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.awsft.knifeandmustache.dto.AccommodationDTO;
import com.awsft.knifeandmustache.exception.custom.ConflictException;
import com.awsft.knifeandmustache.exception.custom.NotFoundException;
import com.awsft.knifeandmustache.model.Accommodation;
import com.awsft.knifeandmustache.model.Barbershop;
import com.awsft.knifeandmustache.new_dto.NewAccommodationDTO;
import com.awsft.knifeandmustache.repository.AccommodationRepository;
import com.awsft.knifeandmustache.repository.BarbershopRepository;
import com.awsft.knifeandmustache.update_dto.UpdateAccommodationDTO;

@Service
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;
    private final BarbershopRepository barbershopRepository;
  
    public AccommodationService(AccommodationRepository accommodationRepository, BarbershopRepository barbershopRepository){
        this.accommodationRepository = accommodationRepository;
        this.barbershopRepository = barbershopRepository;
    }

    // retorna as acomodações da barbearia.id
    public AccommodationDTO findByBarbershopId(Long barbershopId) {
        Accommodation accommodations = accommodationRepository.findByBarbershopId(barbershopId).orElseThrow(() -> new NotFoundException("Barbearia não tem acomodações!"));
        return AccommodationDTO.fromEntity(accommodations);
    }
    
    @Transactional
    public AccommodationDTO createAccommodation(Long barbershopId, NewAccommodationDTO data){
        Barbershop barbershop = barbershopRepository.findById(barbershopId).orElseThrow(() -> new NotFoundException("Barbearia não encontrada!"));
        if (barbershop.getAccommodation() != null) {
            throw new ConflictException("Barbearia já possui Acomodações!");
        }
        Accommodation accommodation = new Accommodation();
        accommodation.setWifi(data.getWifi());
        accommodation.setParking(data.getParking());
        accommodation.setBath(data.getBath());
        accommodation.setAirConditioner(data.getAirConditioner());

        accommodation.setBarbershop(barbershop);
        barbershop.setAccommodation(accommodation);

        accommodationRepository.save(accommodation);
        return AccommodationDTO.fromEntity(accommodation);
    }

    @Transactional
    public AccommodationDTO updateAccommodation(Long barbershopId, UpdateAccommodationDTO data) {
        Accommodation updateAccommodation = accommodationRepository.findByBarbershopId(barbershopId).orElseThrow(() -> new NotFoundException("Acomodações da barbearia não encontrada!"));
        updateAccommodation.setWifi(data.getWifi());
        updateAccommodation.setParking(data.getParking());
        updateAccommodation.setBath(data.getBath());
        updateAccommodation.setAirConditioner(data.getAirConditioner());
        return AccommodationDTO.fromEntity(updateAccommodation);
    }

    @Transactional
    public void deleteAccommodation(Long barbershopId){
        Barbershop barbershop = barbershopRepository.findById(barbershopId).orElseThrow(() -> new NotFoundException("Barbearia não encontrada!"));
        if(barbershop.getAccommodation() == null)
            {throw new NotFoundException("Não existe acomodações para a barbearia!");}
        barbershop.setAccommodation(null);
    }
}

