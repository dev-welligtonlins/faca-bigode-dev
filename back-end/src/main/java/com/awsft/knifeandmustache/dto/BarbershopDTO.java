package com.awsft.knifeandmustache.dto;

import java.util.List;

import com.awsft.knifeandmustache.model.Barbershop;

public class BarbershopDTO {
    private Long id;
    private String name;
    private AddressDTO address;
    private AccommodationDTO accommodation;
    private List<BarbershopScheduleDTO> barbershopSchedule;
    private List<BarberDTO> barbers;

    public static BarbershopDTO fromEntity(Barbershop barbershop) {
        BarbershopDTO dto = new BarbershopDTO();
        dto.id = barbershop.getId();
        dto.name = barbershop.getName();    
        dto.setAddress(barbershop.getAddress() != null ? AddressDTO.fromEntity(barbershop.getAddress()) : null);
        dto.setAccommodation(barbershop.getAccommodation() != null ? AccommodationDTO.fromEntity(barbershop.getAccommodation()) : null);
        
        dto.barbershopSchedule = barbershop.getBarbershopSchedules().stream().map(BarbershopScheduleDTO::fromEntity).toList();
        dto.barbers = barbershop.getBarbers().stream().map(BarberDTO::fromEntity).toList();

        return dto;
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
    public AddressDTO getAddress() {
        return address;
    }
    public void setAddress(AddressDTO address) {
        this.address = address;
    }
    public AccommodationDTO getAccommodation() {
        return accommodation;
    }
    public void setAccommodation(AccommodationDTO accommodation) {
        this.accommodation = accommodation;
    }
    public List<BarbershopScheduleDTO> getBarbershopSchedule() {
        return barbershopSchedule;
    }
    public void setBarbershopSchedule(List<BarbershopScheduleDTO> barbershopSchedule) {
        this.barbershopSchedule = barbershopSchedule;
    }
    public List<BarberDTO> getBarbers() {
        return barbers;
    }
    public void setBarbers(List<BarberDTO> barbers) {
        this.barbers = barbers;
    }
}
