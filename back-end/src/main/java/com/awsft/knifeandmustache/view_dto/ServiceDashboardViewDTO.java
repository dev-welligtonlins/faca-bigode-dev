package com.awsft.knifeandmustache.view_dto;

import java.math.BigDecimal;


public record ServiceDashboardViewDTO(
    Long barbershopId, 
    Long totalServices, 
    BigDecimal avgValue, 
    Long avgDuration,
    String serviceMostPopular){}