package com.awsft.knifeandmustache.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.awsft.knifeandmustache.dto.ServiceDTO;
import com.awsft.knifeandmustache.exception.custom.ConflictException;
import com.awsft.knifeandmustache.exception.custom.ForbiddenException;
import com.awsft.knifeandmustache.exception.custom.NotFoundException;
import com.awsft.knifeandmustache.model.Barbershop;
import com.awsft.knifeandmustache.model.Service;
import com.awsft.knifeandmustache.new_dto.NewServiceDTO;
import com.awsft.knifeandmustache.repository.BarbershopRepository;
import com.awsft.knifeandmustache.repository.ServiceDashboardViewRepository;
import com.awsft.knifeandmustache.repository.ServiceListViewRepository;
import com.awsft.knifeandmustache.repository.ServiceRepository;
import com.awsft.knifeandmustache.update_dto.UpdateServiceDTO;
import com.awsft.knifeandmustache.view_dto.ServiceDashboardViewDTO;
import com.awsft.knifeandmustache.view_dto.ServiceListViewDTO;
import com.awsft.knifeandmustache.view_dto.ServicePageViewDTO;

@org.springframework.stereotype.Service
public class ServiceService{

    private final ServiceRepository serviceRepository;
    private final BarbershopRepository barbershopRepository;
    private final ServiceDashboardViewRepository serviceDashboardViewRepository;
    private final ServiceListViewRepository serviceListViewRepository;
  
    public ServiceService(ServiceRepository serviceRepository, BarbershopRepository barbershopRepository, ServiceDashboardViewRepository serviceDashboardViewRepository, ServiceListViewRepository serviceListViewRepository){
        this.serviceRepository = serviceRepository;
        this.barbershopRepository = barbershopRepository;
        this.serviceDashboardViewRepository = serviceDashboardViewRepository;
        this.serviceListViewRepository = serviceListViewRepository;
    }


    // retorna um unico servico
    public ServiceDTO findById(Long barbershopId, Long serviceId) {
        Service service = serviceRepository.findById(serviceId).orElseThrow(() -> new NotFoundException("Serviço não encontrado!"));
        if(!service.getBarbershop().getId().equals(barbershopId)) {
            throw new ForbiddenException("Serviço não pertence à barbearia!");
        }        
        return ServiceDTO.fromEntity(service);
    }

    public List<ServiceDTO> findByBarbershopIdAndServiceActiveTrue(Long barbershopId) {
        List<Service> services = serviceRepository.findByBarbershopIdAndServiceActiveTrue(barbershopId);
        if(services.isEmpty()) {
            throw new NotFoundException("Barbearia não possui serviços!");
        } 
        return services.stream().map(ServiceDTO::fromEntity).toList();
    }

    @Transactional
    public List<ServiceDTO> createService(Long barbershopId, List<NewServiceDTO> data){
        Barbershop barbershop = barbershopRepository.findById(barbershopId).orElseThrow(() -> new NotFoundException("Barbearia não encontrada!"));        
        
        List<Service> services = data.stream().map(obj -> {
            Service service = new Service();
            service.setServiceDescription(obj.getServiceDescription());
            service.setDuration(obj.getDuration());
            service.setValue(obj.getValue());
            service.setServiceCategory(obj.getServiceCategory());
            service.setServiceActive(true);

            service.setBarbershop(barbershop);
            barbershop.getServices().add(service);
            return service;
        }).toList();

        serviceRepository.saveAll(services);
        return services.stream().map(ServiceDTO::fromEntity).toList();
    }
    @Transactional
    public ServiceDTO updateService(Long barbershopId, UpdateServiceDTO data) {
        Service service = serviceRepository.findById(data.getId()).orElseThrow(() -> new NotFoundException("Serviço não encontrado!"));
        if(!service.getBarbershop().getId().equals(barbershopId))
            throw new ForbiddenException("Serviço não pertence barbearia!");     
        service.setServiceDescription(data.getServiceDescription());
        service.setDuration(data.getDuration());
        service.setValue(data.getValue());
        service.setServiceCategory(data.getServiceCategory());
        return ServiceDTO.fromEntity(service);
    }
    @Transactional
    public void deleteService(Long barbershopId, Long serviceId){
        Service service = serviceRepository.findById(serviceId).orElseThrow(() -> new NotFoundException("Serviço não encontrado!"));
        if(!service.getBarbershop().getId().equals(barbershopId))
            throw new ConflictException("Serviço não pertence barbearia!");
        
        service.setServiceActive(false);
    }

    public ServicePageViewDTO servicePage(Long id){
        ServiceDashboardViewDTO dashboard = serviceDashboardViewRepository.findByBarbershopId(id);
        List<ServiceListViewDTO> services = serviceListViewRepository.findByBarbershopId(id);
        
        return ServicePageViewDTO.fromView(dashboard, services);
    }
}

