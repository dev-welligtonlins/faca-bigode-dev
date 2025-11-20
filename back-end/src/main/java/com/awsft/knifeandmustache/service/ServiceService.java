package com.awsft.knifeandmustache.service;

import java.util.List;

import com.awsft.knifeandmustache.dto.ServiceDTO;
import com.awsft.knifeandmustache.model.Barbershop;
import com.awsft.knifeandmustache.model.Service;
import com.awsft.knifeandmustache.new_dto.NewServiceDTO;
import com.awsft.knifeandmustache.repository.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService implements ICrud<Service>{

    private final ServiceRepository repo;
  
    public ServiceService(ServiceRepository repo){
        this.repo = repo;
    }

    public Service save(Service obj){
        return repo.save(obj);
    }
 
    @Override
    public List<Service> findAll(){
        return repo.findAll();
    }

    public Service getById(Long id){
        return repo.findById(id).orElse(null);
    }

    public List<Service> findByBarbershopIdAndServiceActiveTrue(Long id) {
        return repo.findByBarbershopIdAndServiceActiveTrue(id);
    }

    public List<ServiceDTO> findServicesByBarbershopId(Long id) {
        return repo.findServicesByBarbershopId(id);
    }

    public List<NewServiceDTO> newDto(List<NewServiceDTO> listDto){
        List<Service> list = listDto.stream().map(obj -> {
            Service newObj = new Service();
            newObj.setServiceDescription(obj.getServiceDescription());
            newObj.setDuration(obj.getDuration());
            newObj.setValue(obj.getValue());
            newObj.setServiceCategory(obj.getServiceCategory());
            newObj.setServiceActive(true);

            Barbershop barbershop = new Barbershop();
            barbershop.setId(obj.getBarbershopId());
            newObj.setBarbershop(barbershop);
            
            return newObj;
        }).toList();

        repo.saveAll(list);
        return listDto;
    }

    public ServiceDTO updateDto(Long id, ServiceDTO obj) {
        Service updateObj = getById(id);

        updateObj.setServiceDescription(obj.getServiceDescription());
        updateObj.setDuration(obj.getDuration());
        updateObj.setValue(obj.getValue());
        updateObj.setServiceCategory(obj.getServiceCategory());

        repo.save(updateObj);
        return obj;
    }

    @Override
    public void delete(Long id){
        Service obj = repo.findById(id).orElse(null);
        obj.setServiceActive(false);
        repo.save(obj);
    }


}

