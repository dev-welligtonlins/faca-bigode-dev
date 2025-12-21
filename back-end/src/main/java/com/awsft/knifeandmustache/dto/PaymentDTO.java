package com.awsft.knifeandmustache.dto;

import com.awsft.knifeandmustache.model.EPaymentMethod;
import com.awsft.knifeandmustache.model.Payment;

public class PaymentDTO {
    private Long id;
    private Double value;
    private Boolean paymentStatus;
    private EPaymentMethod paymentMethod;
    
    public static PaymentDTO fromEntity(Payment payment) {
        PaymentDTO dto = new PaymentDTO();
        dto.id = payment.getId();
        dto.value = payment.getValue();
        dto.paymentStatus = payment.getPaymentStatus();
        dto.paymentMethod = payment.getPaymentMethod();
        return dto;
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