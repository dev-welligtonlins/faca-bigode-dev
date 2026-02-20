package com.awsft.knifeandmustache.view_dto;

import java.math.BigDecimal;


public record BarberDashboardViewDTO(
    Long barbershopId, 
    Long totalBarbers, 
    BigDecimal totalValueDay,
    Long totalAppointmentsDay)
    {}