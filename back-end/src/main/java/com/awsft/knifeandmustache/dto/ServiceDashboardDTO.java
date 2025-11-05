package com.awsft.knifeandmustache.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


public class ServiceDashboardDTO {
    
    private List<ServiceDTO> servicesDTO;
    private Long total;
    
    // @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT, pattern = "0.00")
    private BigDecimal averageValueServices;
    private int averageTimeServices;
    
    public ServiceDashboardDTO(List<ServiceDTO> servicesDTO, Long total, BigDecimal averageValueServices,
            int averageTimeServices) {
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

    public BigDecimal getAverageValueServices() {
        return averageValueServices.setScale(2, RoundingMode.HALF_UP);
    }

    public void setAverageValueServices(BigDecimal averageValueServices) {
        this.averageValueServices = averageValueServices;
    }

    public Integer getAverageTimeServices() {
        return averageTimeServices;
    }

    public void setAverageTimeServices(Integer averageTimeServices) {
        this.averageTimeServices = averageTimeServices;
    }

    
}