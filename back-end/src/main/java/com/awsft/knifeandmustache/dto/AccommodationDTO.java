package com.awsft.knifeandmustache.dto;

import com.awsft.knifeandmustache.model.Accommodation;

public class AccommodationDTO {
    private Long id;
    private Boolean wifi;
    private Boolean parking;
    private Boolean bath;
    private Boolean airConditioner;

    public static AccommodationDTO fromEntity(Accommodation accommodation) {
        AccommodationDTO dto = new AccommodationDTO();
        
        dto.setId(accommodation.getId());
        dto.setWifi(accommodation.getWifi());
        dto.setParking(accommodation.getParking());
        dto.setBath(accommodation.getBath());
        dto.setAirConditioner(accommodation.getAirConditioner());
        return dto;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
}
