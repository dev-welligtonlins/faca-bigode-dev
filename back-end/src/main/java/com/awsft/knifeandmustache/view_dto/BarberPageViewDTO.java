package com.awsft.knifeandmustache.view_dto;

import java.util.List;

public record BarberPageViewDTO(
    BarberDashboardViewDTO dashboard,
    List<BarberListViewDTO> barbers){

    public static BarberPageViewDTO fromView(BarberDashboardViewDTO dash, List<BarberListViewDTO> barbers) {
        BarberPageViewDTO viewDto = new BarberPageViewDTO(dash, barbers);
        return viewDto;
    }

}