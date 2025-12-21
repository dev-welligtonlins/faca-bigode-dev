package com.awsft.knifeandmustache.new_dto;

import java.time.LocalTime;

import com.awsft.knifeandmustache.model.EDayWeek;

public class NewBarbershopScheduleDTO {
    private EDayWeek dayWeek;
    private LocalTime openingTime;
    private LocalTime lunchStartTime;
    private LocalTime lunchEndTime; 
    private LocalTime closingTime;

    private Long barbershopId;

    public NewBarbershopScheduleDTO(EDayWeek dayWeek, LocalTime openingTime, LocalTime lunchStartTime,
            LocalTime lunchEndTime, LocalTime closingTime, Long barbershopId) {
        this.dayWeek = dayWeek;
        this.openingTime = openingTime;
        this.lunchStartTime = lunchStartTime;
        this.lunchEndTime = lunchEndTime;
        this.closingTime = closingTime;
        this.barbershopId = barbershopId;
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
    public Long getBarbershopId() {
        return barbershopId;
    }
    public void setBarbershopId(Long barbershopId) {
        this.barbershopId = barbershopId;
    }
}
