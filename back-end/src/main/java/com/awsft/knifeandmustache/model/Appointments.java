package com.awsft.knifeandmustache.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointments")
public class Appointments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "client_name")
    private String clienteName;
    @Column(name = "appointment_time")
    private LocalDateTime appointmentTime;
    

    @OneToMany(mappedBy = "appointments", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Payments> payments = new ArrayList<Payments>();

    @OneToMany(mappedBy = "appointments", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ServiceAppointments> serviceAppointments = new ArrayList<ServiceAppointments>();



    public Appointments() {

    }

    public Appointments(String clienteName, LocalDateTime appointmentTime) {
        this.clienteName = clienteName;
        this.appointmentTime = appointmentTime;
    }

    public Long getId() {
        return id;
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

    public List<Payments> getPayments() {
        return payments;
    }

    public void setPayments(List<Payments> payments) {
        this.payments = payments;
    }

    public List<ServiceAppointments> getServiceAppointments() {
        return serviceAppointments;
    }

    public void setServiceAppointments(List<ServiceAppointments> serviceAppointments) {
        this.serviceAppointments = serviceAppointments;
    }
    
    
}