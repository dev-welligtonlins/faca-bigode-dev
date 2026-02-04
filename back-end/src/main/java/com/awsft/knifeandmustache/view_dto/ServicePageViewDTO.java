package com.awsft.knifeandmustache.view_dto;

import java.util.List;

public record ServicePageViewDTO(
    ServiceDashboardViewDTO dashboard,
    List<ServiceListViewDTO> services){

    public static ServicePageViewDTO fromView(ServiceDashboardViewDTO dash, List<ServiceListViewDTO> services) {
        ServicePageViewDTO viewDto = new ServicePageViewDTO(dash, services);
        return viewDto;
        // dto.payments = a.getPayments()
        //         .stream()
        //         .map(PaymentDTO::fromEntity)
        //         .toList();
    }

}