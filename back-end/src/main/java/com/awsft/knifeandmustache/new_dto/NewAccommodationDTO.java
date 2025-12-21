package com.awsft.knifeandmustache.new_dto;

public class NewAccommodationDTO {
    private Boolean wifi;
    private Boolean parking;
    private Boolean bath;
    private Boolean airConditioner;
    private Long barbershopId;
    
    public NewAccommodationDTO(Boolean wifi, Boolean parking, Boolean bath, Boolean airConditioner, Long barbershopId) {
        this.wifi = wifi;
        this.parking = parking;
        this.bath = bath;
        this.airConditioner = airConditioner;
        this.barbershopId = barbershopId;
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
    public Long getBarbershopId() {
        return barbershopId;
    }
    public void setBarbershopId(Long barbershopId) {
        this.barbershopId = barbershopId;
    }
}
