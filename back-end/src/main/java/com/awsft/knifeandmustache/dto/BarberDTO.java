package com.awsft.knifeandmustache.dto;

public class BarberDTO {
    private Long id;
    private String barberName;
    private String barberUrlSocial;
    private Boolean isHair;
    private Boolean isBeard;
    
    public BarberDTO(Long id, String barberName, String barberUrlSocial, Boolean isHair, Boolean isBeard) {
        this.id = id;
        this.barberName = barberName;
        this.barberUrlSocial = barberUrlSocial;
        this.isHair = isHair;
        this.isBeard = isBeard;
    }

    public Long getId() {
        return id;
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

}
