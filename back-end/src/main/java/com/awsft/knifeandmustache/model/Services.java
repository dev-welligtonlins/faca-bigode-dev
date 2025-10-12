package com.awsft.knifeandmustache.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "services")
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serviceDescription;
    private Integer duration;    
    
    @Column(name = "service_value")
    private Double value;

    @ManyToOne
    @JoinColumn(name = "service_categories_id")
    private ServiceCategories serviceCategory;

    public Services() {
        
    }
    public Services(String serviceDescription, Integer duration, Double value, ServiceCategories serviceCategory) {
        this.serviceDescription = serviceDescription;
        this.duration = duration;
        this.value = value;
        this.serviceCategory = serviceCategory;
    }

    // GET
    public Long getId() {
        return id;
    }

    public String getDescription() {
        return serviceDescription;
    }

    public Integer getDuration() {
        return duration;
    }

    public Double getValue() {
        return value;
    }

    // SET
    public ServiceCategories getServiceCategory() {
        return serviceCategory;
    }

    public void setDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setServiceCategory(ServiceCategories serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    
}