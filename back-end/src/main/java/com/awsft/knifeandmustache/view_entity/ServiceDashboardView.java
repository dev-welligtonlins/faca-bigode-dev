package com.awsft.knifeandmustache.view_entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(name = "view_services_barbershop_dashboard")
public class ServiceDashboardView {
    @Id
    @Column(name = "barbershop_id")
    private Long barbershopId;
    @Column(name = "total_services") 
    private Long totalServices;
    @Column(name = "avg_value")
    private BigDecimal avgValue;
    @Column(name = "avg_duration") 
    private Long avgDuration;
    @Column(name = "service_most_popular")
    private String serviceMostPopular;

    public Long getBarbershopId() {
        return barbershopId;
    }
    public Long getTotalServices() {
        return totalServices;
    }
    public BigDecimal getAvgValue() {
        return avgValue;
    }
    public Long getAvgDuration() {
        return avgDuration;
    }
    public String getServiceMostPopular() {
        return serviceMostPopular;
    }
}
