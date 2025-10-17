package com.awsft.knifeandmustache.model;

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
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payments {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "payment_value")
    private Double value;
    @Column(name = "payment_status")
    private Boolean statusPayment;
    @Column(name = "payment_method")
    @Enumerated(EnumType.STRING)
    private PaymentMethods paymentMethods;

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    @JsonBackReference
    private Appointments appointments;


    public Payments() {
        
    }

    public Payments(Double value, Boolean statusPayment, PaymentMethods paymentMethods, Appointments appointments) {
        this.value = value;
        this.statusPayment = statusPayment;
        this.paymentMethods = paymentMethods;
        this.appointments = appointments;
    }

    public Long getId() {
        return id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(Boolean statusPayment) {
        this.statusPayment = statusPayment;
    }

    public PaymentMethods getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(PaymentMethods paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public Appointments getAppointments() {
        return appointments;
    }

    public void setAppointment(Appointments appointments) {
        this.appointments = appointments;
    }

    

}
