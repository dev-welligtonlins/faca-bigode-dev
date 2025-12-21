package com.awsft.knifeandmustache.model;

import java.util.HashSet;
import java.util.Set;

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
@Table(name = "barbers")
public class Barber {

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

    @Column(name = "barber_active")
    private Boolean barberActive;

    @OneToMany(mappedBy = "barber")
    @JsonBackReference
    private Set<ServiceAppointment> serviceAppointments = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "barbershop_id")
    @JsonBackReference
    private Barbershop barbershop;

    public Barber() {
        
    }
    
    public Barber(String name, String urlSocial, Boolean isHair, Boolean isBeard, Boolean barberActive,
            Set<ServiceAppointment> serviceAppointments, Barbershop barbershop) {
        this.name = name;
        this.urlSocial = urlSocial;
        this.isHair = isHair;
        this.isBeard = isBeard;
        this.barberActive = barberActive;
        this.serviceAppointments = serviceAppointments;
        this.barbershop = barbershop;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public Boolean getBarberActive() {
        return barberActive;
    }
    public void setBarberActive(Boolean barberActive) {
        this.barberActive = barberActive;
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