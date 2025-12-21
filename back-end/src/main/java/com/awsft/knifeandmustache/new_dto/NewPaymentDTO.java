package com.awsft.knifeandmustache.new_dto;

import com.awsft.knifeandmustache.model.EPaymentMethod;


public class NewPaymentDTO {
    private Double value;
    private Boolean paymentStatus;
    private EPaymentMethod paymentMethod;
    private Long appointmentId;

    public NewPaymentDTO(Double value, Boolean paymentStatus, EPaymentMethod paymentMethod, Long appointmentId) {
        this.value = value;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
        this.appointmentId = appointmentId;
    }

    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }
    public Boolean getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public EPaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(EPaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public Long getAppointmentId() {
        return appointmentId;
    }
    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }   
}
