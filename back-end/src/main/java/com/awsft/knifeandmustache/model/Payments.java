package com.awsft.knifeandmustache.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column(name = "appointment_id")   
    private Long appointment;


    public Payments() {
        
    }

    public Payments(Double value, Boolean statusPayment, PaymentMethods paymentMethods, Long appointment) {
        this.value = value;
        this.statusPayment = statusPayment;
        this.paymentMethods = paymentMethods;
        this.appointment = appointment;
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

    public Long getAppointment() {
        return appointment;
    }

    public void setAppointment(Long appointment) {
        this.appointment = appointment;
    }

    

}
