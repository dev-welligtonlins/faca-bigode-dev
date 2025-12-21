package com.awsft.knifeandmustache.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.dto.AddressDTO;
import com.awsft.knifeandmustache.model.Address;
import com.awsft.knifeandmustache.model.Barbershop;
import com.awsft.knifeandmustache.new_dto.NewAddressDTO;
import com.awsft.knifeandmustache.repository.AddressRepository;
import com.awsft.knifeandmustache.update_dto.UpdateAddressDTO;

@Service
public class AddressService implements ICrud<Address>{

    private final AddressRepository repo;
  
    public AddressService(AddressRepository repo){
        this.repo = repo;
    }

    public Address save(Address obj){
        return repo.save(obj);
    }
 
    @Override
    public List<Address> findAll(){
        return repo.findAll();
    }

    public Address getById(Long id){
        return repo.findById(id).orElse(null);
    }

    // retorna o endereço da barbearia
    public AddressDTO findIdDTO(Long id) {
        Address address = repo.findByBarbershopId(id);
        return AddressDTO.fromEntity(address);
    }

    // adiciona endereço da barbearia
    public AddressDTO newDto(NewAddressDTO dto){
        Address newObj = new Address();
        newObj.setCep(dto.getCep());
        newObj.setRoad(dto.getRoad());
        newObj.setNumber(dto.getNumber());
        newObj.setNeighborhood(dto.getNeighborhood());
        newObj.setComplement(dto.getComplement());
        newObj.setCity(dto.getCity());
        newObj.setState(dto.getState());
        Barbershop barbershop = new Barbershop();
        barbershop.setId(dto.getBarbershopId());
        newObj.setBarbershop(barbershop);

        repo.save(newObj);
        Address address = repo.findById(newObj.getId()).orElseThrow(() -> new RuntimeException("Endereço not found"));
        return AddressDTO.fromEntity(address);
    }

    // atualiza endereço
    public AddressDTO updateDto(Long id, UpdateAddressDTO dto) {
        Address updateObj = getById(id);
        updateObj.setCep(dto.getCep());
        updateObj.setRoad(dto.getRoad());
        updateObj.setNumber(dto.getNumber());
        updateObj.setNeighborhood(dto.getNeighborhood());
        updateObj.setComplement(dto.getComplement());
        updateObj.setCity(dto.getCity());
        updateObj.setState(dto.getState());
        repo.save(updateObj);
        return AddressDTO.fromEntity(updateObj);
    }

    @Override
    public void delete(Long id){
        Address obj = repo.findById(id).orElse(null);
        repo.delete(obj);
    }
}

