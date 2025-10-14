package com.awsft.knifeandmustache.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    

    @OneToMany
    @JoinColumn(name = "payments")
    private List<Payments> payments = new ArrayList<Payments>();

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
    
       
}