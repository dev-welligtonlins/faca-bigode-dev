package com.awsft.knifeandmustache.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
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
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "client_name")
    private String clienteName;
    @Column(name = "appointment_time")
    private LocalDateTime appointmentTime;
    
    @Column(name = "appointment_status")
    @Enumerated(EnumType.STRING)
    private EAppointmentStatus appointmentStatus;

    @OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true) 
    @JsonManagedReference
    private Set<Payment> payments = new HashSet<>();

    @OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<ServiceAppointment> serviceAppointments = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "barbershop_id")
    @JsonBackReference
    private Barbershop barbershop;

    public Appointment() {
        
    }

    public Appointment(String clienteName, LocalDateTime appointmentTime, EAppointmentStatus appointmentStatus,
            Set<Payment> payments, Set<ServiceAppointment> serviceAppointments, Barbershop barbershop) {
        this.clienteName = clienteName;
        this.appointmentTime = appointmentTime;
        this.appointmentStatus = appointmentStatus;
        this.payments = payments;
        this.serviceAppointments = serviceAppointments;
        this.barbershop = barbershop;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getClienteName() {
        return clienteName;
    }
    public void setClienteName(String clienteName) {
        this.clienteName = clienteName;
    }
    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }
    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    public EAppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }
    public void setAppointmentStatus(EAppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }
    public Set<Payment> getPayments() {
        return payments;
    }
    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
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