package com.awsft.knifeandmustache.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.awsft.knifeandmustache.model.Appointment;
import com.awsft.knifeandmustache.model.EAppointmentStatus;

public class AppointmentDTO {
    private Long id;
    private String clientName; 
    private LocalDateTime appointmentTime;
    private List<PaymentDTO> payments;
    private List<ServiceAppointmentDTO> serviceAppointments;
    private EAppointmentStatus appointmentStatus;

    public static AppointmentDTO fromEntity(Appointment a) {
        AppointmentDTO dto = new AppointmentDTO();

        dto.id = a.getId();
        dto.clientName = a.getClienteName();
        dto.appointmentTime = a.getAppointmentTime();
        dto.appointmentStatus = a.getAppointmentStatus();

        dto.payments = a.getPayments()
                .stream()
                .map(PaymentDTO::fromEntity)
                .toList();

        dto.serviceAppointments = a.getServiceAppointments()
                .stream()
                .map(ServiceAppointmentDTO::fromEntity)
                .toList();

        return dto;
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
    public List<PaymentDTO> getPayments() {
        return payments;
    }
    public void setPayments(List<PaymentDTO> payments) {
        this.payments = payments;
    }
    public List<ServiceAppointmentDTO> getServiceAppointments() {
        return serviceAppointments;
    }
    public void setServiceAppointments(List<ServiceAppointmentDTO> serviceAppointments) {
        this.serviceAppointments = serviceAppointments;
    }
    public EAppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }
    public void setAppointmentStatus(EAppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }            
}
