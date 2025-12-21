package com.awsft.knifeandmustache.update_dto;

import com.awsft.knifeandmustache.model.EPaymentMethod;

public class UpdatePaymentDTO {
    private Long id;
    private Double value;
    private Boolean paymentStatus;
    private EPaymentMethod paymentMethod;

    public UpdatePaymentDTO(Long id, Double value, Boolean paymentStatus, EPaymentMethod paymentMethod) {
        this.id = id;
        this.value = value;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
}
