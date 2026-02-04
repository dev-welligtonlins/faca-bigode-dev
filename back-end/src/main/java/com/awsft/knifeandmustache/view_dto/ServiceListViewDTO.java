package com.awsft.knifeandmustache.view_dto;

import java.math.BigDecimal;


public record ServiceListViewDTO(
    Long barbershopId, 
    String serviceDescription, 
    BigDecimal value, 
    Long duration,
    String serviceCategory){}