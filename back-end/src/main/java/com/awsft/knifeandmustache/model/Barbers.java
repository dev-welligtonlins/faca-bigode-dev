package com.awsft.knifeandmustache.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "barbers")
public class Barbers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "barber_name")
    private String name;
    @Column(name = "url_social")
    private String urlSocial;
    @Column(name = "is_hair")
    private Boolean isHair;
    @Column(name = "is_beard")
    private Boolean isBeard;

    public Barbers() {

    }

    public Barbers(String name, String urlSocial, Boolean isHair, Boolean isBeard) {
        this.name = name;
        this.urlSocial = urlSocial;
        this.isHair = isHair;
        this.isBeard = isBeard;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlSocial() {
        return urlSocial;
    }

    public void setUrlSocial(String urlSocial) {
        this.urlSocial = urlSocial;
    }

    public Boolean getIsHair() {
        return isHair;
    }

    public void setIsHair(Boolean isHair) {
        this.isHair = isHair;
    }

    public Boolean getIsBeard() {
        return isBeard;
    }

    public void setIsBeard(Boolean isBeard) {
        this.isBeard = isBeard;
    }

    
}