    package com.awsft.knifeandmustache.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.awsft.knifeandmustache.dto.AddressDTO;
import com.awsft.knifeandmustache.exception.custom.ConflictException;
import com.awsft.knifeandmustache.exception.custom.NotFoundException;
import com.awsft.knifeandmustache.model.Address;
import com.awsft.knifeandmustache.model.Barbershop;
import com.awsft.knifeandmustache.new_dto.NewAddressDTO;
import com.awsft.knifeandmustache.repository.AddressRepository;
import com.awsft.knifeandmustache.repository.BarbershopRepository;
import com.awsft.knifeandmustache.update_dto.UpdateAddressDTO;


@org.springframework.stereotype.Service
public class AddressService{

    private final AddressRepository addressRepository;
    private final BarbershopRepository barbershopRepository;
  
    public AddressService(AddressRepository addressRepository, BarbershopRepository barbershopRepository){
        this.addressRepository = addressRepository;
        this.barbershopRepository = barbershopRepository;
    }
 

    public AddressDTO findByBarbershopId(Long barbershopId) {
        Address address = addressRepository.findByBarbershopId(barbershopId).orElseThrow(() -> new NotFoundException("Endereço da barbearia não encontrado"));
        return AddressDTO.fromEntity(address);
    }

    @Transactional
    public AddressDTO createAdress(Long barbershopId, NewAddressDTO data){

        Barbershop barbershop = barbershopRepository.findById(barbershopId).orElseThrow(() -> new NotFoundException("Barbearia não encontrada!"));
        if (barbershop.getAddress() != null ) { 
            throw new ConflictException("Barbearia já possui endereço!");
        }

        Address address = new Address();
        address.setCep(data.getCep());
        address.setRoad(data.getRoad());
        address.setNumber(data.getNumber());
        address.setNeighborhood(data.getNeighborhood());
        address.setComplement(data.getComplement());
        address.setCity(data.getCity());
        address.setState(data.getState());
        address.setBarbershop(barbershop);
        barbershop.setAddress(address);

        addressRepository.save(address);
        return AddressDTO.fromEntity(address);
    }

    @Transactional
    public AddressDTO updateAdress(Long barbershopId, UpdateAddressDTO data) {
        Address updateAddress = addressRepository.findByBarbershopId(barbershopId).orElseThrow(() -> new NotFoundException("Endereço da barbearia não encontrado!"));

        updateAddress.setCep(data.getCep());
        updateAddress.setRoad(data.getRoad());
        updateAddress.setNumber(data.getNumber());
        updateAddress.setNeighborhood(data.getNeighborhood());
        updateAddress.setComplement(data.getComplement());
        updateAddress.setCity(data.getCity());
        updateAddress.setState(data.getState());
        return AddressDTO.fromEntity(updateAddress);
    }

    @Transactional
    public void deleteAdress(Long barbershopId){
        Barbershop barbershop = barbershopRepository.findById(barbershopId).orElseThrow(() -> new NotFoundException("Barbearia não encontrada!"));
        if(barbershop.getAddress() == null)
            throw new ConflictException("Não existe endereço para a barbearia!");
        barbershop.setAddress(null);    
    }
}

