package com.awsft.knifeandmustache.dto;

import java.time.LocalTime;

import com.awsft.knifeandmustache.model.ServiceAppointment;


public class ServiceAppointmentDTO {
    private Long id;
    private String name;
    private LocalTime time;
    private String serviceDescription;
    private Integer duration;
    private Double value;

    public static ServiceAppointmentDTO fromEntity(ServiceAppointment serviceAppointment) {
        ServiceAppointmentDTO dto = new ServiceAppointmentDTO();
        dto.id = serviceAppointment.getId();
        dto.name = serviceAppointment.getBarber().getName();
        dto.time = serviceAppointment.getTime();
        dto.serviceDescription = serviceAppointment.getService().getServiceDescription();
        dto.duration = serviceAppointment.getService().getDuration();
        dto.value = serviceAppointment.getService().getValue();
        return dto;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }
    public String getServiceDescription() {
        return serviceDescription;
    }
    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }
    public Integer getDuration() {
        return duration;
    }
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }   
    
    
}
