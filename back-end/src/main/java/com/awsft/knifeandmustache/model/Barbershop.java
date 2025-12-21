package com.awsft.knifeandmustache.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "barbershops")
public class Barbershop {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "barbershops_name")
    private String name;

    @OneToOne(mappedBy = "barbershop", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Address address;

    @OneToOne(mappedBy = "barbershop", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Accommodation accommodation;

    @OneToMany(mappedBy = "barbershop", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<BarbershopSchedule> barbershopSchedules = new HashSet<>();

    @OneToMany(mappedBy = "barbershop", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Barber> barbers = new HashSet<>();

    @OneToMany(mappedBy = "barbershop", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Service> services = new HashSet<>(); 
    
    @OneToMany(mappedBy = "barbershop", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Appointment> appointments = new HashSet<>();

    public Barbershop() {

    }

    public Barbershop(String name, Address address, Accommodation accommodation,
            Set<BarbershopSchedule> barbershopSchedules, Set<Barber> barbers, Set<Service> services,
            Set<Appointment> appointments) {
        this.name = name;
        this.address = address;
        this.accommodation = accommodation;
        this.barbershopSchedules = barbershopSchedules;
        this.barbers = barbers;
        this.services = services;
        this.appointments = appointments;
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
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public Accommodation getAccommodation() {
        return accommodation;
    }
    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }
    public Set<BarbershopSchedule> getBarbershopSchedules() {
        return barbershopSchedules;
    }
    public void setBarbershopSchedules(Set<BarbershopSchedule> barbershopSchedules) {
        this.barbershopSchedules = barbershopSchedules;
    }
    public Set<Barber> getBarbers() {
        return barbers;
    }
    public void setBarbers(Set<Barber> barbers) {
        this.barbers = barbers;
    }
    public Set<Service> getServices() {
        return services;
    }
    public void setServices(Set<Service> services) {
        this.services = services;
    }
    public Set<Appointment> getAppointments() {
        return appointments;
    }
    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }    
}
