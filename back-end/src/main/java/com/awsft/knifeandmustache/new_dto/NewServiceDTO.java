package com.awsft.knifeandmustache.new_dto;

import com.awsft.knifeandmustache.model.ECategoryService;

public class NewServiceDTO {
    private String serviceDescription;
    private Integer duration;
    private Double value;
    private ECategoryService serviceCategory;
    private Long barbershopId;

    public NewServiceDTO(String serviceDescription, Integer duration, Double value, ECategoryService serviceCategory,
            Long barbershopId) {
        this.serviceDescription = serviceDescription;
        this.duration = duration;
        this.value = value;
        this.serviceCategory = serviceCategory;
        this.barbershopId = barbershopId;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public ECategoryService getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(ECategoryService serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public Long getBarbershopId() {
        return barbershopId;
    }

    public void setBarbershopId(Long barbershopId) {
        this.barbershopId = barbershopId;
    }    
}
