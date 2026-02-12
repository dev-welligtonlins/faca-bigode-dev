package com.awsft.knifeandmustache.view_dto;



public record BarberListViewDTO(
    Long barbershopId, 
    String barberName, 
    String urlSocial, 
    Boolean isHair,
    Boolean isBeard){}