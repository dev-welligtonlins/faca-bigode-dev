package com.awsft.knifeandmustache.dto;

import com.awsft.knifeandmustache.model.ECategoryService;

public class ServiceDTO {
    private String serviceDescription;
    private Integer duration;
    private Double value;
    private ECategoryService serviceCategory;
    
    public ServiceDTO(String serviceDescription, Integer duration, Double value, ECategoryService serviceCategory) {
        this.serviceDescription = serviceDescription;
        this.duration = duration;
        this.value = value;
        this.serviceCategory = serviceCategory;
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
}