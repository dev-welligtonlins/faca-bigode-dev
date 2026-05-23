package com.awsft.knifeandmustache.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.awsft.knifeandmustache.dto.BarberDTO;
import com.awsft.knifeandmustache.exception.custom.ConflictException;
import com.awsft.knifeandmustache.exception.custom.ForbiddenException;
import com.awsft.knifeandmustache.exception.custom.NotFoundException;
import com.awsft.knifeandmustache.model.Barber;
import com.awsft.knifeandmustache.model.Barbershop;
import com.awsft.knifeandmustache.new_dto.NewBarberDTO;
import com.awsft.knifeandmustache.repository.BarberDashboardViewRepository;
import com.awsft.knifeandmustache.repository.BarberListViewRepository;
import com.awsft.knifeandmustache.repository.BarberRepository;
import com.awsft.knifeandmustache.repository.BarbershopRepository;
import com.awsft.knifeandmustache.update_dto.UpdateBarberDTO;
import com.awsft.knifeandmustache.view_dto.BarberDashboardViewDTO;
import com.awsft.knifeandmustache.view_dto.BarberListViewDTO;
import com.awsft.knifeandmustache.view_dto.BarberPageViewDTO;

@org.springframework.stereotype.Service
public class BarberService{

    private final BarberRepository barberRepository;
    private final BarbershopRepository barbershopRepository;
    private final BarberDashboardViewRepository barberDashboardViewRepository;
    private final BarberListViewRepository barberListViewRepository;
  
    public BarberService(BarberRepository barberRepository,
                         BarbershopRepository barbershopRepository, 
                         BarberDashboardViewRepository barberDashboardViewRepository,
                         BarberListViewRepository barberListViewRepository){
        this.barberRepository = barberRepository;
        this.barbershopRepository = barbershopRepository;
        this.barberDashboardViewRepository = barberDashboardViewRepository;
        this.barberListViewRepository = barberListViewRepository;
    }

   

    // public List<Barber> findByBarbershopIdAndBarberActiveTrueAndIsHairTrue(Long id) {
    //     return repo.findByBarbershopIdAndBarberActiveTrueAndIsHairTrue(id);
    // }

    // public List<Barber> findByBarbershopIdAndBarberActiveTrueAndIsBeardTrue(Long id) {
    //     return repo.findByBarbershopIdAndBarberActiveTrueAndIsBeardTrue(id);
    // }

    // retorna todos barbeiros ativos da barbearia.id
    public List<BarberDTO> findByBarbershopIdAndBarberActiveTrue(Long barbershopId) {
        List<Barber> barbers = barberRepository.findByBarbershopIdAndBarberActiveTrue(barbershopId);
        if(barbers.isEmpty()) {
            throw new NotFoundException("Barbearia não possui barbeiros!");
        }     
        return barbers.stream().map(BarberDTO::fromEntity).toList();
    }
    // retorna um unico barbeiro pelo seu id
    public BarberDTO findById(Long barbershopId, Long barberId) {
        Barber barber = barberRepository.findById(barberId).orElseThrow(() -> new NotFoundException("Barbeiro não encontrado!"));
        if(!barber.getBarbershop().getId().equals(barbershopId)) {
            throw new ForbiddenException("Barbeiro não pertence à barbearia!");
        }
        return BarberDTO.fromEntity(barber);
    }

    @Transactional
    public List<BarberDTO> createBarber(Long barbershopId, List<NewBarberDTO> data){
        Barbershop barbershop = barbershopRepository.findById(barbershopId).orElseThrow(() -> new NotFoundException("Barbearia não encontrada!"));        
                
        List<Barber> barbers = data.stream().map(obj -> {
            Barber barber = new Barber();
            barber.setName(obj.getBarberName());
            barber.setUrlSocial(obj.getBarberUrlSocial());
            barber.setIsHair(obj.getIsHair());
            barber.setIsBeard(obj.getIsBeard());
            barber.setBarberActive(true);

            barber.setBarbershop(barbershop);
            barbershop.getBarbers().add(barber);
            
            return barber;
        }).toList();

        barberRepository.saveAll(barbers);
        return barbers.stream().map(BarberDTO::fromEntity).toList();
    }
    
    @Transactional
    public BarberDTO updateBarber(Long barbershopId, UpdateBarberDTO data) {
        Barber barber = barberRepository.findById(data.getId()).orElseThrow(() -> new NotFoundException("Barbeiro não encontrado!"));
        if(!barber.getBarbershop().getId().equals(barbershopId))
            throw new ForbiddenException("Barbeiro não pertence à barbearia!");  
        barber.setName(data.getBarberName());
        barber.setUrlSocial(data.getBarberUrlSocial());
        barber.setIsHair(data.getIsHair());
        barber.setIsBeard(data.getIsBeard());
        return BarberDTO.fromEntity(barber);
    }

    @Transactional
    public void deleteBarber(Long barbershopId, Long barberId){
        Barber barber = barberRepository.findById(barberId).orElseThrow(() -> new NotFoundException("Barbeiro não encontrado!"));
        if(!barber.getBarbershop().getId().equals(barbershopId))
            throw new ConflictException("Barbeiro não pertence à barbearia!");
                
        barber.setBarberActive(false);
    }

    public BarberPageViewDTO barberPage(Long id){
        BarberDashboardViewDTO dashboard = barberDashboardViewRepository.findByBarbershopId(id);
        List<BarberListViewDTO> barbers = barberListViewRepository.findByBarbershopId(id);
        
        return BarberPageViewDTO.fromView(dashboard, barbers);
    }
}

