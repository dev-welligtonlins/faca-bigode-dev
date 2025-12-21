package com.awsft.knifeandmustache.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "accommodations")
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean wifi;
    private Boolean parking;
    private Boolean bath;
    private Boolean airConditioner;

    @OneToOne
    @JoinColumn(name = "barbershop_id")
    @JsonBackReference
    private Barbershop barbershop;
    
    public Accommodation() {
        
    }

    public Accommodation(Boolean wifi, Boolean parking, Boolean bath, Boolean airConditioner) {
        this.wifi = wifi;
        this.parking = parking;
        this.bath = bath;
        this.airConditioner = airConditioner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getParking() {
        return parking;
    }

    public void setParking(Boolean parking) {
        this.parking = parking;
    }

    public Boolean getBath() {
        return bath;
    }

    public void setBath(Boolean bath) {
        this.bath = bath;
    }

    public Boolean getAirConditioner() {
        return airConditioner;
    }

    public void setAirConditioner(Boolean airConditioner) {
        this.airConditioner = airConditioner;
    }

    public Barbershop getBarbershop() {
        return barbershop;
    }

    public void setBarbershop(Barbershop barbershop) {
        this.barbershop = barbershop;
    }
    
}