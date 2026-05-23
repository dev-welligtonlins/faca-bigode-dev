package com.awsft.knifeandmustache.new_dto;


import java.time.LocalTime;

public class NewServiceAppointmentDTO {
    private Long serviceId;
    private Long barberId;
    private LocalTime time;
    
    public NewServiceAppointmentDTO( Long serviceId, Long barberId, LocalTime time) {
        this.serviceId = serviceId;
        this.barberId = barberId;
        this.time = time;
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
