package com.awsft.knifeandmustache.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.dto.AccommodationDTO;
import com.awsft.knifeandmustache.model.Accommodation;
import com.awsft.knifeandmustache.model.Barbershop;
import com.awsft.knifeandmustache.new_dto.NewAccommodationDTO;
import com.awsft.knifeandmustache.repository.AccommodationRepository;
import com.awsft.knifeandmustache.update_dto.UpdateAccommodationDTO;

@Service
public class AccommodationService implements ICrud<Accommodation>{

    private final AccommodationRepository repo;
  
    public AccommodationService(AccommodationRepository repo){
        this.repo = repo;
    }

    public Accommodation save(Accommodation obj){
        return repo.save(obj);
    }
 
    @Override
    public List<Accommodation> findAll(){
        return repo.findAll();
    }

    public Accommodation getById(Long id){
        return repo.findById(id).orElse(null);
    }

    // retorna uma acomodação da barbearia pelo accommodation.id
    public AccommodationDTO findIdDTO(Long id) {
        Accommodation accommodation= repo.findById(id).orElseThrow(() -> new RuntimeException("accommodation não encontrado"));
        return AccommodationDTO.fromEntity(accommodation);
    }

    // retorna as acomodações da barbearia.id
    public List<AccommodationDTO> findByBarbershopId(Long id) {
        List<Accommodation> accommodations = repo.findByBarbershopId(id);
        return accommodations.stream().map(AccommodationDTO::fromEntity).toList();
    }
    
    // adiciona as acomodações da barbearia
    public AccommodationDTO newDto(NewAccommodationDTO dto){
        Accommodation newObj = new Accommodation();
        newObj.setWifi(dto.getWifi());
        newObj.setParking(dto.getParking());
        newObj.setBath(dto.getBath());
        newObj.setAirConditioner(dto.getAirConditioner());

        Barbershop barbershop = new Barbershop();
        barbershop.setId(dto.getBarbershopId());
        newObj.setBarbershop(barbershop);

        repo.save(newObj);
        Accommodation accommodation = repo.findById(newObj.getId()).orElseThrow(() -> new RuntimeException("Endereço not found"));
        return AccommodationDTO.fromEntity(accommodation);
    }

    // atualiza acomodações da barbearia
    public AccommodationDTO updateDto(Long id, UpdateAccommodationDTO dto) {
        Accommodation updateObj = getById(id);
        updateObj.setWifi(dto.getWifi());
        updateObj.setParking(dto.getParking());
        updateObj.setBath(dto.getBath());
        updateObj.setAirConditioner(dto.getAirConditioner());
        repo.save(updateObj);
        return AccommodationDTO.fromEntity(updateObj);
    }

    @Override
    public void delete(Long id){
        Accommodation obj = repo.findById(id).orElse(null);
        repo.delete(obj);
    }
}

