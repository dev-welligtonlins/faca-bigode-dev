package com.awsft.knifeandmustache.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.awsft.knifeandmustache.dto.BarbershopScheduleDTO;
import com.awsft.knifeandmustache.exception.custom.ConflictException;
import com.awsft.knifeandmustache.exception.custom.ForbiddenException;
import com.awsft.knifeandmustache.exception.custom.NotFoundException;
import com.awsft.knifeandmustache.model.Barbershop;
import com.awsft.knifeandmustache.model.BarbershopSchedule;
import com.awsft.knifeandmustache.model.EDayWeek;
import com.awsft.knifeandmustache.new_dto.NewBarbershopScheduleDTO;
import com.awsft.knifeandmustache.repository.BarbershopRepository;
import com.awsft.knifeandmustache.repository.BarbershopScheduleRepository;
import com.awsft.knifeandmustache.update_dto.UpdateBarbershopScheduleDTO;

@org.springframework.stereotype.Service
public class BarbershopScheduleService{

    private final BarbershopScheduleRepository barbershopScheduleRepository;
    private final BarbershopRepository barbershopRepository;
  
    public BarbershopScheduleService(BarbershopRepository barbershopRepository, BarbershopScheduleRepository barbershopScheduleRepository){
        this.barbershopScheduleRepository = barbershopScheduleRepository;
        this.barbershopRepository = barbershopRepository;
    }

    // retorna um horário da barbearia
    public BarbershopScheduleDTO findByDayWeekAndBarbershopId(Long barbershopId, EDayWeek dayWeek) {
        BarbershopSchedule barbershopSchedule = barbershopScheduleRepository.findByDayWeekAndBarbershopId(dayWeek, barbershopId).orElseThrow(() -> new NotFoundException("Horário/Dia não encontrado!"));
        return BarbershopScheduleDTO.fromEntity(barbershopSchedule);
    }

    // retorna todos horários da barbearia
    public List<BarbershopScheduleDTO> findByBarbershopId(Long barbershopId) {
        List<BarbershopSchedule> barbershopSchedules = barbershopScheduleRepository.findByBarbershopId(barbershopId);
        if(barbershopSchedules.isEmpty()) {
            throw new NotFoundException("Barbearia não possui horários!");
        } 
        return barbershopSchedules.stream().map(BarbershopScheduleDTO::fromEntity).toList();
    }

    @Transactional
    public List<BarbershopScheduleDTO> createBarbershopSchedule(Long barbershopId, List<NewBarbershopScheduleDTO> data){
        Barbershop barbershop = barbershopRepository.findById(barbershopId).orElseThrow(() -> new NotFoundException("Barbearia não encontrada"));       
               
        Set<BarbershopSchedule> schedules = data.stream().map(obj -> {
            BarbershopSchedule schedule = new BarbershopSchedule();
            schedule.setDayWeek(obj.getDayWeek());
            schedule.setOpeningTime(obj.getOpeningTime());
            schedule.setLunchStartTime(obj.getLunchStartTime());
            schedule.setLunchEndTime(obj.getLunchEndTime());
            schedule.setClosingTime(obj.getClosingTime());


            schedule.setBarbershop(barbershop);
            barbershop.getBarbershopSchedules().add(schedule);
            return schedule;
        }).collect(Collectors.toSet());

        barbershopScheduleRepository.saveAll(schedules);
        return schedules.stream().map(BarbershopScheduleDTO::fromEntity).toList();
    }

    @Transactional
    public BarbershopScheduleDTO updateBarbershopSchedule(Long barbershopId, UpdateBarbershopScheduleDTO data) {
        BarbershopSchedule barbershopSchedule = barbershopScheduleRepository.findById(data.getId()).orElseThrow(() -> new NotFoundException("Horário não encontrado!"));
        if(!barbershopSchedule.getBarbershop().getId().equals(barbershopId))
            throw new ForbiddenException("Horário não pertence à barbearia!");  
                barbershopSchedule.setOpeningTime(data.getOpeningTime());
        barbershopSchedule.setLunchStartTime(data.getLunchStartTime());
        barbershopSchedule.setLunchEndTime(data.getLunchEndTime());
        barbershopSchedule.setClosingTime(data.getClosingTime());
        return BarbershopScheduleDTO.fromEntity(barbershopSchedule);
    }

    public void deleteBarbershopSchedule(Long barbershopId, EDayWeek dayWeek){
        BarbershopSchedule barbershopSchedule = barbershopScheduleRepository.findByDayWeekAndBarbershopId(dayWeek, barbershopId).orElseThrow(() -> new NotFoundException("Horário/Dia não encontrado!"));
        barbershopSchedule.setOpeningTime(null);
        barbershopSchedule.setLunchStartTime(null);
        barbershopSchedule.setLunchEndTime(null);
        barbershopSchedule.setClosingTime(null);   

    }
}

