package com.awsft.knifeandmustache.dto;

import java.util.List;

public class BarberDashboardDTO {

    private List<BarberDTO> barbersDTO;
    private Long totalBarbers;
    private List<ServiceAppointmentDTO> serviceAppointmentsDTO;
    private Long totalServiceAppointment;   
    private Double total;    

    public BarberDashboardDTO(List<BarberDTO> barbersDTO, Long totalBarbers,
            List<ServiceAppointmentDTO> serviceAppointmentsDTO, Long totalServiceAppointment, Double total) {
        this.barbersDTO = barbersDTO;
        this.totalBarbers = totalBarbers;
        this.serviceAppointmentsDTO = serviceAppointmentsDTO;
        this.totalServiceAppointment = totalServiceAppointment;
        this.total = total;
    }
    public List<BarberDTO> getBarbersDTO() {
        return barbersDTO;
    }
    public void setBarbersDTO(List<BarberDTO> barbersDTO) {
        this.barbersDTO = barbersDTO;
    }
    public Long getTotalBarbers() {
        return totalBarbers;
    }
    public void setTotalBarbers(Long totalBarbers) {
        this.totalBarbers = totalBarbers;
    }
    public List<ServiceAppointmentDTO> getServiceAppointmentsDTO() {
        return serviceAppointmentsDTO;
    }
    public void setServiceAppointmentsDTO(List<ServiceAppointmentDTO> serviceAppointmentsDTO) {
        this.serviceAppointmentsDTO = serviceAppointmentsDTO;
    }
    public Long getTotalServiceAppointment() {
        return totalServiceAppointment;
    }
    public void setTotalServiceAppointment(Long totalServiceAppointment) {
        this.totalServiceAppointment = totalServiceAppointment;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }

}
