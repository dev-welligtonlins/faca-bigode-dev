package com.awsft.knifeandmustache.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.awsft.knifeandmustache.dto.BarbershopDTO;
import com.awsft.knifeandmustache.model.Barbershop;
import com.awsft.knifeandmustache.model.BarbershopSchedule;
import com.awsft.knifeandmustache.new_dto.NewBarbershopDTO;
import com.awsft.knifeandmustache.repository.BarbershopRepository;
import com.awsft.knifeandmustache.update_dto.UpdateBarbershopDTO;

@org.springframework.stereotype.Service
public class BarbershopService implements ICrud<Barbershop>{

    private final BarbershopRepository repo;
  
    public BarbershopService(BarbershopRepository repo){
        this.repo = repo;
    }

    public Barbershop save(Barbershop obj){
        return repo.save(obj);
    }
 
    @Override
    public List<Barbershop> findAll(){
        return repo.findAll();
    }

    public Barbershop getById(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id){
        Barbershop obj = repo.findById(id).orElse(null);
        repo.delete(obj);
    }

    // retorna um atendimento.id
    public BarbershopDTO findIdDTO(Long id) {
        Barbershop barbershop = repo.findById(id).orElseThrow(() -> new RuntimeException("Barbearia não encontrado"));
        return BarbershopDTO.fromEntity(barbershop);
    }

    // retorna todos atendimentos de barbearia.id
    public List<BarbershopDTO> findAllDTO() {
        List<Barbershop> list = repo.findAll();

        return list.stream().map(BarbershopDTO::fromEntity).toList();
    }
  //    adiciona nova barbearia
    public BarbershopDTO newDto(NewBarbershopDTO dto){
        Barbershop newObj = new Barbershop();
        newObj.setName(dto.getName());
        repo.save(newObj);
        return BarbershopDTO.fromEntity(newObj);
    }

    public BarbershopDTO updateDto(Long id, UpdateBarbershopDTO dto) {
        Barbershop updateObj = getById(id);
        updateObj.setName(dto.getName());

        updateObj.getAddress().setCep(dto.getAddress().getCep());
        updateObj.getAddress().setRoad(dto.getAddress().getRoad());
        updateObj.getAddress().setNumber(dto.getAddress().getNumber());
        updateObj.getAddress().setNeighborhood(dto.getAddress().getNeighborhood());
        updateObj.getAddress().setComplement(dto.getAddress().getComplement());
        updateObj.getAddress().setCity(dto.getAddress().getCity());
        updateObj.getAddress().setState(dto.getAddress().getState());

        updateObj.getAccommodation().setWifi(dto.getAccommodation().getWifi());
        updateObj.getAccommodation().setParking(dto.getAccommodation().getParking());
        updateObj.getAccommodation().setBath(dto.getAccommodation().getBath());
        updateObj.getAccommodation().setAirConditioner(dto.getAccommodation().getAirConditioner());


         Map<Long, BarbershopSchedule> existingSchedules = updateObj.getBarbershopSchedules().stream()
            .filter(s -> s.getId() != null) 
            .collect(Collectors.toMap(BarbershopSchedule::getId, Function.identity()));

        Set<BarbershopSchedule> schedules =
            dto.getBarbershopSchedule().stream()
                .map(s -> {

                    BarbershopSchedule schedule =
                        Optional.ofNullable(s.getId())
                            .map(existingSchedules::get)
                            .orElseGet(() -> {
                                BarbershopSchedule newSchedule = new BarbershopSchedule();
                                newSchedule.setBarbershop(updateObj);
                                return newSchedule;
                            });

                    schedule.setDayWeek(s.getDayWeek());
                    schedule.setOpeningTime(s.getOpeningTime());
                    schedule.setLunchStartTime(s.getLunchStartTime());
                    schedule.setLunchEndTime(s.getLunchEndTime());
                    schedule.setClosingTime(s.getClosingTime());
                    return schedule;
                })
                .collect(Collectors.toSet());
        
        updateObj.getBarbershopSchedules().clear();
        schedules.forEach(updateObj.getBarbershopSchedules()::add);

        repo.save(updateObj);
        Barbershop barbershop = repo.findById(updateObj.getId()).orElseThrow(() -> new RuntimeException("Barbershop not found"));
        return BarbershopDTO.fromEntity(barbershop);
    }

}

