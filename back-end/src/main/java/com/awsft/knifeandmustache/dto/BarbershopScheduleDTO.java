package com.awsft.knifeandmustache.dto;

import java.time.LocalTime;

import com.awsft.knifeandmustache.model.BarbershopSchedule;
import com.awsft.knifeandmustache.model.EDayWeek;

public class BarbershopScheduleDTO {
    private Long id;
    private EDayWeek dayWeek;
    private LocalTime openingTime;
    private LocalTime lunchStartTime;
    private LocalTime lunchEndTime; 
    private LocalTime closingTime;

    public static BarbershopScheduleDTO fromEntity(BarbershopSchedule schedule){
        BarbershopScheduleDTO dto = new BarbershopScheduleDTO();
        dto.setDayWeek(schedule.getDayWeek());
        dto.setOpeningTime(schedule.getOpeningTime());
        dto.setLunchStartTime(schedule.getLunchStartTime());
        dto.setLunchEndTime(schedule.getLunchEndTime());
        dto.setClosingTime(schedule.getClosingTime());
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EDayWeek getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(EDayWeek dayWeek) {
        this.dayWeek = dayWeek;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getLunchStartTime() {
        return lunchStartTime;
    }

    public void setLunchStartTime(LocalTime lunchStartTime) {
        this.lunchStartTime = lunchStartTime;
    }

    public LocalTime getLunchEndTime() {
        return lunchEndTime;
    }

    public void setLunchEndTime(LocalTime lunchEndTime) {
        this.lunchEndTime = lunchEndTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    
}
