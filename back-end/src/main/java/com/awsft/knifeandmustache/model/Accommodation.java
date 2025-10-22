package com.awsft.knifeandmustache.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Boolean air_conditioner;
    
    public Accommodation() {
        
    }

    public Accommodation(Boolean wifi, Boolean parking, Boolean bath, Boolean air_conditioner) {
        this.wifi = wifi;
        this.parking = parking;
        this.bath = bath;
        this.air_conditioner = air_conditioner;
    }

    public Long getId() {
        return id;
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

    public Boolean getAir_conditioner() {
        return air_conditioner;
    }

    public void setAir_conditioner(Boolean air_conditioner) {
        this.air_conditioner = air_conditioner;
    }    
}