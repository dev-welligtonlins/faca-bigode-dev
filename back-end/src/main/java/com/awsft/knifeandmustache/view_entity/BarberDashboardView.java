package com.awsft.knifeandmustache.view_entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(name = "view_barbers_barbershop_dashboard")
public class BarberDashboardView {
    @Id
    @Column(name = "barbershop_id")
    private Long barbershopId;
    @Column(name = "total_barbers") 
    private Long totalBarbers;
    @Column(name = "total_value_day")
    private BigDecimal totalValueDay;

    public Long getBarbershopId() {
        return barbershopId;
    }
    public Long getTotalBarbers() {
        return totalBarbers;
    }
    public BigDecimal getTotalValueDay() {
        return totalValueDay;
    }

    
}
