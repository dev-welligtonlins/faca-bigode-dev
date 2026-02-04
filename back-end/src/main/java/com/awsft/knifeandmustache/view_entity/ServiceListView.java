package com.awsft.knifeandmustache.view_entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(name = "view_services_barbershop")
public class ServiceListView {
    @Id
    @Column(name = "barbershop_id")
    private Long barbershopId;
    @Column(name = "service_description") 
    private String serviceDescription;
    @Column(name = "service_value")
    private BigDecimal value;
    @Column(name = "duration") 
    private Long duration;
    @Column(name = "category")
    private String serviceCategory;
    
    public Long getBarbershopId() {
        return barbershopId;
    }
    public String getServiceDescription() {
        return serviceDescription;
    }
    public BigDecimal getValue() {
        return value;
    }
    public Long getDuration() {
        return duration;
    }
    public String getServiceCategory() {
        return serviceCategory;
    }

    
}
