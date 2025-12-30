package com.awsft.knifeandmustache.dto;

import java.math.BigDecimal;

import com.awsft.knifeandmustache.model.ECategoryService;
import com.awsft.knifeandmustache.model.Service;

public class ServiceDTO {
    private Long id;
    private String serviceDescription;
    private Integer duration;
    private BigDecimal value;
    private ECategoryService serviceCategory;
    
    public static ServiceDTO fromEntity(Service service) {
        ServiceDTO dto = new ServiceDTO();
        dto.id = service.getId();
        dto.serviceDescription = service.getServiceDescription();
        dto.duration = service.getDuration();
        dto.value = service.getValue();
        dto.serviceCategory = service.getServiceCategory();

        return dto;
    }

    public Long getId() {
        return id;
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