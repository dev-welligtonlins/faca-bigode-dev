package com.awsft.knifeandmustache.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "services")
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String service_description;
    private Integer duration;
    
    @Column(name = "service_value")
    private Double value;

    public Services() {
        
    }

    public Services(String description, Integer duration, Double value) {
        this.service_description = service_description;
        this.duration = duration;
        this.value = value;
    }

    // GET
    public Long getId() {
        return id;
    }

    public String getDescription() {
        return service_description;
    }

    public Integer getDuration() {
        return duration;
    }

    public Double getValue() {
        return value;
    }

    public void setDescription(String service_description) {
        this.service_description = service_description;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setValue(Double value) {
        this.value = value;
    }

}