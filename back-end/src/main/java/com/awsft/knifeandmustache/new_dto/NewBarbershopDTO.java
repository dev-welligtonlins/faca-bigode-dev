package com.awsft.knifeandmustache.new_dto;

public class NewBarbershopDTO {
    private String name;

    public NewBarbershopDTO(String name) {
        this.name = name;
        
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }   
}
