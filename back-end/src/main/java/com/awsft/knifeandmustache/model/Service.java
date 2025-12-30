package com.awsft.knifeandmustache.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

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
    @Column(name = "service_value", precision = 10, scale = 2)
    private BigDecimal value;
    @Column(name = "service_active")
    private Boolean serviceActive;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private ECategoryService serviceCategory;

    @OneToMany
    @JoinColumn(name = "service_appointments")
    @JsonBackReference
    private Set<ServiceAppointment> serviceAppointments = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "barbershop_id")
    @JsonBackReference
    private Barbershop barbershop;

    public Service() {
        
    }

    public Service(String serviceDescription, Integer duration, BigDecimal value, Boolean serviceActive,
            ECategoryService serviceCategory, Set<ServiceAppointment> serviceAppointments, Barbershop barbershop) {
        this.serviceDescription = serviceDescription;
        this.duration = duration;
        this.value = value;
        this.serviceActive = serviceActive;
        this.serviceCategory = serviceCategory;
        this.serviceAppointments = serviceAppointments;
        this.barbershop = barbershop;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value) {
        this.value = value;
    }
    public Boolean getServiceActive() {
        return serviceActive;
    }
    public void setServiceActive(Boolean serviceActive) {
        this.serviceActive = serviceActive;
    }
    public ECategoryService getServiceCategory() {
        return serviceCategory;
    }
    public void setServiceCategory(ECategoryService serviceCategory) {
        this.serviceCategory = serviceCategory;
    }
    public Set<ServiceAppointment> getServiceAppointments() {
        return serviceAppointments;
    }
    public void setServiceAppointments(Set<ServiceAppointment> serviceAppointments) {
        this.serviceAppointments = serviceAppointments;
    }
    public Barbershop getBarbershop() {
        return barbershop;
    }
    public void setBarbershop(Barbershop barbershop) {
        this.barbershop = barbershop;
    }
}