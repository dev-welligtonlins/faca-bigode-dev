package com.awsft.knifeandmustache.new_dto;


import java.time.LocalTime;

public class NewServiceAppointmentDTO {
    private Long appointmentId;
    private Long serviceId;
    private Long barberId;
    private LocalTime time;
    
    public NewServiceAppointmentDTO(Long appointmentId, Long serviceId, Long barberId, LocalTime time) {
        this.appointmentId = appointmentId;
        this.serviceId = serviceId;
        this.barberId = barberId;
        this.time = time;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }
    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }
    public Long getServiceId() {
        return serviceId;
    }
    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
    public Long getBarberId() {
        return barberId;
    }
    public void setBarberId(Long barberId) {
        this.barberId = barberId;
    }
    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }
}
