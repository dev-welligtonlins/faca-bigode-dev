package com.awsft.knifeandmustache.view_entity;

import org.springframework.data.annotation.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(name = "view_barbers_barbershop")
public class BarberListView {
    @Id
    @Column(name = "barbershop_id")
    private Long barbershopId;
    @Column(name = "barber_name") 
    private String barberName;
    @Column(name = "url_social")
    private String urlSocial;
    @Column(name = "is_hair") 
    private Boolean isHair;
    @Column(name = "is_beard")
    private Boolean isBeard;

    public Long getBarbershopId() {
        return barbershopId;
    }
    public String getBarberName() {
        return barberName;
    }
    public String getUrlSocial() {
        return urlSocial;
    }
    public Boolean getIsHair() {
        return isHair;
    }
    public Boolean getIsBeard() {
        return isBeard;
    }

    
}
