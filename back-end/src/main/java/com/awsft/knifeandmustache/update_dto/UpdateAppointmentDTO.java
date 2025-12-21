package com.awsft.knifeandmustache.update_dto;

import java.time.LocalDateTime;
import java.util.List;

public class UpdateAppointmentDTO {
    private Long id;
    private String clientName;
    private LocalDateTime appointmentTime;
    private List<UpdatePaymentDTO> payments; 
    private List<UpdateServiceAppointmentDTO> serviceAppointments;
    
    public UpdateAppointmentDTO(Long id, String clientName, LocalDateTime appointmentTime,
            List<UpdatePaymentDTO> payments, List<UpdateServiceAppointmentDTO> serviceAppointments) {
        this.id = id;
        this.clientName = clientName;
        this.appointmentTime = appointmentTime;
        this.payments = payments;
        this.serviceAppointments = serviceAppointments;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }
    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    public List<UpdatePaymentDTO> getPayments() {
        return payments;
    }
    public void setPayments(List<UpdatePaymentDTO> payments) {
        this.payments = payments;
    }
    public List<UpdateServiceAppointmentDTO> getServiceAppointments() {
        return serviceAppointments;
    }
    public void setServiceAppointments(List<UpdateServiceAppointmentDTO> serviceAppointments) {
        this.serviceAppointments = serviceAppointments;
    } 
}
