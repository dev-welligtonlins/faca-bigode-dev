package com.awsft.knifeandmustache.update_dto;

public class UpdateAccommodationDTO {
    private Boolean wifi;
    private Boolean parking;
    private Boolean bath;
    private Boolean airConditioner;
    
    public UpdateAccommodationDTO(Boolean wifi, Boolean parking, Boolean bath, Boolean airConditioner) {
        this.wifi = wifi;
        this.parking = parking;
        this.bath = bath;
        this.airConditioner = airConditioner;
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
    
}
