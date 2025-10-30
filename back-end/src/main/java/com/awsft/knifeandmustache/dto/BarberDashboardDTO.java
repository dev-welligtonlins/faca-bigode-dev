package com.awsft.knifeandmustache.dto;

import java.util.List;

public class BarberDashboardDTO {

    private List<BarberDTO> barbers;
    private Long totalBarbers;
    private List<ServiceAppointmentDTO> serviceAppointmentDTOs;
    private Long totalServiceAppointment;
    
    public BarberDashboardDTO(List<BarberDTO> barbers, Long totalBarbers,
            List<ServiceAppointmentDTO> serviceAppointmentDTOs, Long totalServiceAppointment) {
        this.barbers = barbers;
        this.totalBarbers = totalBarbers;
        this.serviceAppointmentDTOs = serviceAppointmentDTOs;
        this.totalServiceAppointment = totalServiceAppointment;
    }

    public List<BarberDTO> getBarbers() {
        return barbers;
    }

    public void setBarbers(List<BarberDTO> barbers) {
        this.barbers = barbers;
    }

    public Long getTotalBarbers() {
        return totalBarbers;
    }

    public void setTotalBarbers(Long totalBarbers) {
        this.totalBarbers = totalBarbers;
    }

    public List<ServiceAppointmentDTO> getServiceAppointmentDTOs() {
        return serviceAppointmentDTOs;
    }

    public void setServiceAppointmentDTOs(List<ServiceAppointmentDTO> serviceAppointmentDTOs) {
        this.serviceAppointmentDTOs = serviceAppointmentDTOs;
    }

    public Long getTotalServiceAppointment() {
        return totalServiceAppointment;
    }

    public void setTotalServiceAppointment(Long totalServiceAppointment) {
        this.totalServiceAppointment = totalServiceAppointment;
    }    
    
    
}
