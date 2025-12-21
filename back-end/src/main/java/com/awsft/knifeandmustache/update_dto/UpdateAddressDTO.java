package com.awsft.knifeandmustache.update_dto;

public class UpdateAddressDTO {
    private Long id;
    private String cep;
    private String road;
    private Long number;
    private String neighborhood;
    private String complement;
    private String city;
    private String state;
    
    public UpdateAddressDTO(Long id, String cep, String road, Long number, String neighborhood, String complement,
            String city, String state) {
        this.id = id;
        this.cep = cep;
        this.road = road;
        this.number = number;
        this.neighborhood = neighborhood;
        this.complement = complement;
        this.city = city;
        this.state = state;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
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
    public String getComplement() {
        return complement;
    }
    public void setComplement(String complement) {
        this.complement = complement;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }    
}
