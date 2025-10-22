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
public class Payment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "payment_value")
    private Double value;
    @Column(name = "payment_status")
    private Boolean statusPayment;
    @Column(name = "payment_method")
    @Enumerated(EnumType.STRING)
    private EPaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    @JsonBackReference
    private Appointment appointment;

    public Payment() {        
    }

    public Payment(Double value, Boolean statusPayment, EPaymentMethod paymentMethod, Appointment appointment) {
        this.value = value;
        this.statusPayment = statusPayment;
        this.paymentMethod = paymentMethod;
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
    public Appointment getAppointment() {
        return appointment;
    }
    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    public EPaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(EPaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
