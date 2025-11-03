package com.awsft.knifeandmustache.dto;

import java.time.LocalTime;

import com.awsft.knifeandmustache.model.EAppointmentStatus;
import com.awsft.knifeandmustache.model.ECategoryService;


public class ServiceAppointmentDTO {
    private EAppointmentStatus appointmentStatus;
    private LocalTime time;
    private String serviceDescription;
    private ECategoryService serviceCategory;
    private Integer duration;
    private Double value;

    public ServiceAppointmentDTO(EAppointmentStatus appointmentStatus, LocalTime time, String serviceDescription, ECategoryService serviceCategory, Integer duration, Double value) {
        this.appointmentStatus = appointmentStatus;
        this.time = time;
        this.serviceDescription = serviceDescription;
        this.serviceCategory = serviceCategory;
        this.duration = duration;
        this.value = value;
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
    public ECategoryService getServiceCategory() {
        return serviceCategory;
    }
    public void setServiceCategory(ECategoryService serviceCategory) {
        this.serviceCategory = serviceCategory;
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
    public EAppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }
    public void setAppointmentStatus(EAppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

}
