package com.awsft.knifeandmustache.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @OneToMany
    @JoinColumn(name = "service_appointments")
    @JsonBackReference
    private List<ServiceAppointments> serviceAppointments = new ArrayList<ServiceAppointments>();

    public Services() {
        
    }

    public Services(String serviceDescription, Integer duration, Double value, ServiceCategories serviceCategory) {
        this.serviceDescription = serviceDescription;
        this.duration = duration;
        this.value = value;
        this.serviceCategory = serviceCategory;
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
    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }
    public ServiceCategories getServiceCategory() {
        return serviceCategory;
    }
    public void setServiceCategory(ServiceCategories serviceCategory) {
        this.serviceCategory = serviceCategory;
    }
    public List<ServiceAppointments> getServiceAppointments() {
        return serviceAppointments;
    }
    public void setServiceAppointments(List<ServiceAppointments> serviceAppointments) {
        this.serviceAppointments = serviceAppointments;
    }

    
}