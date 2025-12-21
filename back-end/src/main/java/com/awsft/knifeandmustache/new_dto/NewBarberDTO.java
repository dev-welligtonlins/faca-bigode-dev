package com.awsft.knifeandmustache.new_dto;

public class NewBarberDTO {
    private String barberName;
    private String barberUrlSocial;
    private Boolean isHair;
    private Boolean isBeard;
    private Long barbershopId;
    
    public NewBarberDTO(String barberName, String barberUrlSocial, Boolean isHair, Boolean isBeard, Long barbershopId) {
        this.barberName = barberName;
        this.barberUrlSocial = barberUrlSocial;
        this.isHair = isHair;
        this.isBeard = isBeard;
        this.barbershopId = barbershopId;
    }

    public String getBarberName() {
        return barberName;
    }

    public void setBarberName(String barberName) {
        this.barberName = barberName;
    }

    public String getBarberUrlSocial() {
        return barberUrlSocial;
    }

    public void setBarberUrlSocial(String barberUrlSocial) {
        this.barberUrlSocial = barberUrlSocial;
    }

    public Boolean getIsHair() {
        return isHair;
    }

    public void setIsHair(Boolean isHair) {
        this.isHair = isHair;
    }

    public Boolean getIsBeard() {
        return isBeard;
    }

    public void setIsBeard(Boolean isBeard) {
        this.isBeard = isBeard;
    }

    public Long getBarbershopId() {
        return barbershopId;
    }

    public void setBarbershopId(Long barbershopId) {
        this.barbershopId = barbershopId;
    }
}
