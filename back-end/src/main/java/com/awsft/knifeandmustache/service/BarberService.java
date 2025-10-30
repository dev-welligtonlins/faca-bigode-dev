package com.awsft.knifeandmustache.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.dto.BarberDTO;
import com.awsft.knifeandmustache.model.Barber;
import com.awsft.knifeandmustache.repository.BarberRepository;

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

    @Override
    public void delete(Long id){
        Barber obj = repo.findById(id).orElse(null);
        obj.setBarberActive(false);
        repo.save(obj);
    }

    public List<Barber> findByBarbershopIdAndBarberActiveTrueAndIsHairTrue(Long id) {
        return repo.findByBarbershopIdAndBarberActiveTrueAndIsHairTrue(id);
    }

    public List<Barber> findByBarbershopIdAndBarberActiveTrueAndIsBeardTrue(Long id) {
        return repo.findByBarbershopIdAndBarberActiveTrueAndIsBeardTrue(id);
    }

    public List<Barber> findByBarbershopIdAndBarberActiveTrue(Long id) {
        return repo.findByBarbershopIdAndBarberActiveTrue(id);
    }

    public List<BarberDTO> findBarbersByBarbershopId(Long id) {
        return repo.findBarbersByBarbershopId(id);
    }
}

