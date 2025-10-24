package com.awsft.knifeandmustache.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
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
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "client_name")
    private String clienteName;
    @Column(name = "appointment_time")
    private LocalDateTime appointmentTime;
    

    @OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true) 
    @JsonManagedReference
    private List<Payment> payments = new ArrayList<Payment>();

    @OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ServiceAppointment> serviceAppointments = new ArrayList<ServiceAppointment>();

    @ManyToOne
    @JoinColumn(name = "barbershop_id")
    @JsonBackReference
    private Barbershop barbershop;

    public Appointment() {

    }

    public Appointment(String clienteName, LocalDateTime appointmentTime) {
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

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<ServiceAppointment> getServiceAppointments() {
        return serviceAppointments;
    }

    public void setServiceAppointments(List<ServiceAppointment> serviceAppointment) {
        this.serviceAppointments = serviceAppointment;
    }
    
    
}