package com.awsft.knifeandmustache.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.dto.BarbershopScheduleDTO;
import com.awsft.knifeandmustache.model.Barbershop;
import com.awsft.knifeandmustache.model.BarbershopSchedule;
import com.awsft.knifeandmustache.new_dto.NewBarbershopScheduleDTO;
import com.awsft.knifeandmustache.repository.BarbershopScheduleRepository;
import com.awsft.knifeandmustache.update_dto.UpdateBarbershopScheduleDTO;

@Service
public class BarbershopScheduleService implements ICrud<BarbershopSchedule>{

    private final BarbershopScheduleRepository repo;
  
    public BarbershopScheduleService(BarbershopScheduleRepository repo){
        this.repo = repo;
    }

    public BarbershopSchedule save(BarbershopSchedule obj){
        return repo.save(obj);
    }
 
    @Override
    public List<BarbershopSchedule> findAll(){
        return repo.findAll();
    }

    public BarbershopSchedule getById(Long id){
        return repo.findById(id).orElse(null);
    }

    // retorna um horário da barbearia
    public BarbershopScheduleDTO findIdDTO(Long id) {
        BarbershopSchedule barbershopSchedule = repo.findById(id).orElseThrow(() -> new RuntimeException("Horário/Dia não encontrado"));
        return BarbershopScheduleDTO.fromEntity(barbershopSchedule);
    }

    // retorna todos horários da barbearia
    public List<BarbershopScheduleDTO> findByBarbershopId(Long id) {
        List<BarbershopSchedule> barbershopSchedules = repo.findByBarbershopId(id);
        return barbershopSchedules.stream().map(BarbershopScheduleDTO::fromEntity).toList();
    }

    // adiciona horário para barbearia
    public BarbershopScheduleDTO newDto(NewBarbershopScheduleDTO dto){
        BarbershopSchedule newObj = new BarbershopSchedule();
        newObj.setDayWeek(dto.getDayWeek());
        newObj.setOpeningTime(dto.getOpeningTime());
        newObj.setLunchStartTime(dto.getLunchStartTime());
        newObj.setLunchEndTime(dto.getLunchEndTime());
        newObj.setClosingTime(dto.getClosingTime());

        Barbershop barbershop = new Barbershop();
        barbershop.setId(dto.getBarbershopId());
        newObj.setBarbershop(barbershop);

        repo.save(newObj);
        BarbershopSchedule barbershopSchedule = repo.findById(newObj.getId()).orElseThrow(() -> new RuntimeException("Horário not register"));
        return BarbershopScheduleDTO.fromEntity(barbershopSchedule);
    }

    // atualiza endereço
    public BarbershopScheduleDTO updateDto(Long id, UpdateBarbershopScheduleDTO dto) {
        BarbershopSchedule updateObj = getById(id);
        updateObj.setDayWeek(dto.getDayWeek());
        updateObj.setOpeningTime(dto.getOpeningTime());
        updateObj.setLunchStartTime(dto.getLunchStartTime());
        updateObj.setLunchEndTime(dto.getLunchEndTime());
        updateObj.setClosingTime(dto.getClosingTime());
        repo.save(updateObj);
        return BarbershopScheduleDTO.fromEntity(updateObj);
    }

    @Override
    public void delete(Long id){
        BarbershopSchedule obj = repo.findById(id).orElse(null);
        repo.delete(obj);
    }
}

