package com.awsft.knifeandmustache.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ServiceDashboardDTO {
    
    private List<ServiceDTO> servicesDTO;
    private Long total;
    
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT, pattern = "0.00")
    private Double averageValueServices;
    private Double averageTimeServices;
    
    public ServiceDashboardDTO(List<ServiceDTO> servicesDTO, Long total, Double averageValueServices,
            Double averageTimeServices) {
        this.servicesDTO = servicesDTO;
        this.total = total;
        this.averageValueServices = averageValueServices;
        this.averageTimeServices = averageTimeServices;
    }

    public List<ServiceDTO> getServicesDTO() {
        return servicesDTO;
    }

    public void setServicesDTO(List<ServiceDTO> servicesDTO) {
        this.servicesDTO = servicesDTO;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Double getAverageValueServices() {
        return averageValueServices;
    }

    public void setAverageValueServices(Double averageValueServices) {
        this.averageValueServices = averageValueServices;
    }

    public Double getAverageTimeServices() {
        return averageTimeServices;
    }

    public void setAverageTimeServices(Double averageTimeServices) {
        this.averageTimeServices = averageTimeServices;
    }

    
}