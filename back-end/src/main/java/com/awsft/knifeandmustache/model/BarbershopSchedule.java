package com.awsft.knifeandmustache.model;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "barbershop_schedules")
public class BarbershopSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day_week")
    @Enumerated(EnumType.STRING)
    private EDayWeek dayWeek;
    @Column(name = "opening_time")
    private LocalTime openingTime;
    @Column(name = "lunch_start_time")
    private LocalTime lunchStartTime;
    @Column(name = "lunch_end_time")
    private LocalTime lunchEndTime; 
    @Column(name = "closing_time")
    private LocalTime closingTime;

    @ManyToOne
    @JoinColumn(name = "barbershop_id")
    @JsonBackReference
    private Barbershop barbershop;



    
    public BarbershopSchedule() {

    }
    public BarbershopSchedule(EDayWeek dayWeek, LocalTime openingTime, LocalTime lunchStartTime, LocalTime lunchEndTime,
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
    public Barbershop getBarbershop() {
        return barbershop;
    }
    public void setBarbershop(Barbershop barbershop) {
        this.barbershop = barbershop;
    } 

}
