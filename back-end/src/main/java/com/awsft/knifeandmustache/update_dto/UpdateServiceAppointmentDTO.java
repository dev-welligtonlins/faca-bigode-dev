package com.awsft.knifeandmustache.update_dto;

import java.time.LocalTime;

public class UpdateServiceAppointmentDTO {
    private Long id;
    private Long serviceId;
    private Long barberId;
    private LocalTime time;

    public UpdateServiceAppointmentDTO(Long id, Long serviceId, Long barberId, LocalTime time) {
        this.id = id;
        this.serviceId = serviceId;
        this.barberId = barberId;
        this.time = time;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
