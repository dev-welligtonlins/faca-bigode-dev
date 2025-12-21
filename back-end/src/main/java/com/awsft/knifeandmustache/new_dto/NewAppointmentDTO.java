package com.awsft.knifeandmustache.new_dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NewAppointmentDTO {
    private String clientName;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime appointmentTime; 
    private List<NewPaymentDTO> payments;
    private List<NewServiceAppointmentDTO> serviceAppointments;
    private Long barbershopId;
    
    public NewAppointmentDTO(String clientName, LocalDateTime appointmentTime, List<NewPaymentDTO> payments,
            List<NewServiceAppointmentDTO> serviceAppointments, Long barbershopId) {
        this.clientName = clientName;
        this.appointmentTime = appointmentTime;
        this.payments = payments;
        this.serviceAppointments = serviceAppointments;
        this.barbershopId = barbershopId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<NewPaymentDTO> getPayments() {
        return payments;
    }

    public void setPayments(List<NewPaymentDTO> payments) {
        this.payments = payments;
    }

    public List<NewServiceAppointmentDTO> getServiceAppointments() {
        return serviceAppointments;
    }

    public void setServiceAppointments(List<NewServiceAppointmentDTO> serviceAppointments) {
        this.serviceAppointments = serviceAppointments;
    }

    public Long getBarbershopId() {
        return barbershopId;
    }

    public void setBarbershopId(Long barbershopId) {
        this.barbershopId = barbershopId;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    
}
