package com.awsft.knifeandmustache.update_dto;

import java.util.List;

public class UpdateBarbershopDTO {
    private Long id;
    private String name;
    private UpdateAddressDTO address;
    private UpdateAccommodationDTO accommodation;
    private List<UpdateBarbershopScheduleDTO> barbershopSchedule;
    
    public UpdateBarbershopDTO(Long id, String name, UpdateAddressDTO address, UpdateAccommodationDTO accommodation,
            List<UpdateBarbershopScheduleDTO> barbershopSchedule) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.accommodation = accommodation;
        this.barbershopSchedule = barbershopSchedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UpdateAddressDTO getAddress() {
        return address;
    }

    public void setAddress(UpdateAddressDTO address) {
        this.address = address;
    }

    public UpdateAccommodationDTO getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(UpdateAccommodationDTO accommodation) {
        this.accommodation = accommodation;
    }

    public List<UpdateBarbershopScheduleDTO> getBarbershopSchedule() {
        return barbershopSchedule;
    }

    public void setBarbershopSchedule(List<UpdateBarbershopScheduleDTO> barbershopSchedule) {
        this.barbershopSchedule = barbershopSchedule;
    }
    
    
}
