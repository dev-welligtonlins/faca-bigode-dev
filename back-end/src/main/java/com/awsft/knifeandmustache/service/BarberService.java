package com.awsft.knifeandmustache.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.dto.BarberDTO;
import com.awsft.knifeandmustache.model.Barber;
import com.awsft.knifeandmustache.model.Barbershop;
import com.awsft.knifeandmustache.new_dto.NewBarberDTO;
import com.awsft.knifeandmustache.repository.BarberRepository;
import com.awsft.knifeandmustache.update_dto.UpdateBarberDTO;

@Service
public class BarberService implements ICrud<Barber>{

    private final BarberRepository repo;
  
    public BarberService(BarberRepository repo){
        this.repo = repo;
    }

    public Barber save(Barber obj){
        return repo.save(obj);
    }

    @Override // ESSE MÉTODO DEVERÁ SER DELETADO NO FINAL
    public List<Barber> findAll(){
        return repo.findAll();
    }

    public Barber getById(Long id){
        return repo.findById(id).orElse(null);
    }

    public List<Barber> findByBarbershopIdAndBarberActiveTrueAndIsHairTrue(Long id) {
        return repo.findByBarbershopIdAndBarberActiveTrueAndIsHairTrue(id);
    }

    public List<Barber> findByBarbershopIdAndBarberActiveTrueAndIsBeardTrue(Long id) {
        return repo.findByBarbershopIdAndBarberActiveTrueAndIsBeardTrue(id);
    }

    // retorna todos barbeiros ativos da barbearia.id
    public List<BarberDTO> findByBarbershopIdAndBarberActiveTrue(Long id) {
        List<Barber> barbers = repo.findByBarbershopIdAndBarberActiveTrue(id);
        return barbers.stream().map(BarberDTO::fromEntity).toList();
    }
    // retorna um unico barbeiro pelo seu id
    public BarberDTO findIdDTO(Long id) {
        Barber barber = repo.findById(id).orElseThrow(() -> new RuntimeException("Barbeiro não encontrado"));
        return BarberDTO.fromEntity(barber);
    }

    public List<BarberDTO> findBarbersByBarbershopId(Long id) {
        List<Barber> barbers = repo.findBarbersByBarbershopId(id);
        return barbers.stream().map(BarberDTO::fromEntity).toList();
    }

    // adiciona novos barbeiros
    public List<BarberDTO> newDto(List<NewBarberDTO> listDto){
        List<Barber> list = listDto.stream().map(obj -> {
            Barber newObj = new Barber();
            newObj.setName(obj.getBarberName());
            newObj.setUrlSocial(obj.getBarberUrlSocial());
            newObj.setIsHair(obj.getIsHair());
            newObj.setIsBeard(obj.getIsBeard());
            newObj.setBarberActive(true);

            Barbershop barbershop = new Barbershop();
            barbershop.setId(obj.getBarbershopId());
            newObj.setBarbershop(barbershop);
            
            return newObj;
        }).toList();

        repo.saveAll(list);
        return list.stream().map(BarberDTO::fromEntity).toList();
    }

    public BarberDTO updateDto(Long id, UpdateBarberDTO obj) {
        Barber updateObj = getById(id);
        updateObj.setName(obj.getBarberName());
        updateObj.setUrlSocial(obj.getBarberUrlSocial());
        updateObj.setIsHair(obj.getIsHair());
        updateObj.setIsBeard(obj.getIsBeard());
        repo.save(updateObj);
        return BarberDTO.fromEntity(updateObj);
    }

    @Override
    public void delete(Long id){
        Barber obj = repo.findById(id).orElse(null);
        obj.setBarberActive(false);
        repo.save(obj);
    }
}

