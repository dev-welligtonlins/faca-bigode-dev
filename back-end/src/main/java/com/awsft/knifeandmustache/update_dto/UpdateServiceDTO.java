package com.awsft.knifeandmustache.update_dto;

import java.math.BigDecimal;

import com.awsft.knifeandmustache.model.ECategoryService;

public class UpdateServiceDTO {
    private Long id;
    private String serviceDescription;
    private Integer duration;
    private BigDecimal value;
    private ECategoryService serviceCategory;

    public UpdateServiceDTO(Long id, String serviceDescription, Integer duration, BigDecimal value, ECategoryService serviceCategory) {
        this.id = id;
        this.serviceDescription = serviceDescription;
        this.duration = duration;
        this.value = value;
        this.serviceCategory = serviceCategory;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value) {
        this.value = value;
    }
    public ECategoryService getServiceCategory() {
        return serviceCategory;
    }
    public void setServiceCategory(ECategoryService serviceCategory) {
        this.serviceCategory = serviceCategory;
    } 
}
