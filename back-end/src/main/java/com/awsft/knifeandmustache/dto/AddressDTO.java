package com.awsft.knifeandmustache.dto;

import com.awsft.knifeandmustache.model.Address;

public class AddressDTO {
    private Long id;
    private String road;
    private Long number;
    private String neighborhood;
    private String city;

    public static AddressDTO fromEntity(Address address) {
        AddressDTO dto = new AddressDTO();
        dto.id = address.getId();
        dto.road = address.getRoad();
        dto.number = address.getNumber();
        dto.neighborhood = address.getNeighborhood();
        dto.city = address.getCity();

        return dto;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRoad() {
        return road;
    }
    public void setRoad(String road) {
        this.road = road;
    }
    public Long getNumber() {
        return number;
    }
    public void setNumber(Long number) {
        this.number = number;
    }
    public String getNeighborhood() {
        return neighborhood;
    }
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }   
}
