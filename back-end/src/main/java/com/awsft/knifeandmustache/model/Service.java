package com.awsft.knifeandmustache.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serviceDescription;
    private Integer duration;    
    @Column(name = "service_value")
    private Double value;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private ECategoryService serviceCategory;

    @OneToMany
    @JoinColumn(name = "service_appointments")
    @JsonBackReference
    private List<ServiceAppointment> serviceAppointments = new ArrayList<ServiceAppointment>();

    @ManyToOne
    @JoinColumn(name = "barbershop_id")
    @JsonBackReference
    private Barbershop barbershop;

    public Service() {
        
    }

    public Service(String serviceDescription, Integer duration, Double value, ECategoryService serviceCategory) {
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
    public ECategoryService getServiceCategory() {
        return serviceCategory;
    }
    public void setServiceCategory(ECategoryService serviceCategory) {
        this.serviceCategory = serviceCategory;
    }
    public List<ServiceAppointment> getServiceAppointments() {
        return serviceAppointments;
    }
    public void setServiceAppointments(List<ServiceAppointment> serviceAppointments) {
        this.serviceAppointments = serviceAppointments;
    }

    public Barbershop getBarbershop() {
        return barbershop;
    }

    public void setBarbershop(Barbershop barbershop) {
        this.barbershop = barbershop;
    }

}