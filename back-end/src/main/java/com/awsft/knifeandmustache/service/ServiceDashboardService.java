package com.awsft.knifeandmustache.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.dto.ServiceDTO;
import com.awsft.knifeandmustache.dto.ServiceDashboardDTO;
import com.awsft.knifeandmustache.repository.ServiceRepository;

@Service
public class ServiceDashboardService {

    private final ServiceRepository serviceRepository;

    public ServiceDashboardService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public ServiceDashboardDTO getServiceDash(Long id) {
        List<ServiceDTO> services = serviceRepository.findServicesByBarbershopId(id);
          
        Long sizeServices = (long) services.size();
        
        BigDecimal averageValue = BigDecimal.valueOf(services.stream().mapToDouble(obj -> obj.getValue()).average().orElse(0.0));
        int averageTime = (int) services.stream().mapToDouble(obj -> obj.getDuration()).average().orElse(0.0);

        return new ServiceDashboardDTO(services, sizeServices, averageValue, averageTime);
    }

}
