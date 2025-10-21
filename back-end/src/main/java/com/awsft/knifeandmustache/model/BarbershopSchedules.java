package com.awsft.knifeandmustache.model;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "barbershop_schedules")
public class BarbershopSchedules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day_week")
    @Enumerated(EnumType.STRING)
    private DayWeek dayWeek;
    @Column(name = "opening_time")
    private LocalTime openingTime;
    @Column(name = "lunch_start_time")
    private LocalTime lunchStartTime;
    @Column(name = "lunch_end_time")
    private LocalTime lunchEndTime; 
    @Column(name = "closing_time")
    private LocalTime closingTime;

    public BarbershopSchedules() {

    }
    public BarbershopSchedules(DayWeek dayWeek, LocalTime openingTime, LocalTime lunchStartTime, LocalTime lunchEndTime,
            LocalTime closingTime) {
        this.dayWeek = dayWeek;
        this.openingTime = openingTime;
        this.lunchStartTime = lunchStartTime;
        this.lunchEndTime = lunchEndTime;
        this.closingTime = closingTime;
    }
    public Long getId() {
        return id;
    }
    public DayWeek getDayWeek() {
        return dayWeek;
    }
    public void setDayWeek(DayWeek dayWeek) {
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
