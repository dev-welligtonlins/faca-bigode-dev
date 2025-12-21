package com.awsft.knifeandmustache.service;

import java.util.List;

import com.awsft.knifeandmustache.dto.ServiceDTO;
import com.awsft.knifeandmustache.model.Barbershop;
import com.awsft.knifeandmustache.model.Service;
import com.awsft.knifeandmustache.new_dto.NewServiceDTO;
import com.awsft.knifeandmustache.repository.ServiceRepository;
import com.awsft.knifeandmustache.update_dto.UpdateServiceDTO;

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
    // retorna todos barbeiros ativos da barbearia.id
    public List<ServiceDTO> findByBarbershopIdAndServiceActiveTrue(Long id) {
        List<Service> services = repo.findServicesByBarbershopIdAndServiceActiveTrue(id);
        return services.stream().map(ServiceDTO::fromEntity).toList();
    }

    // retorna um unico servico
    public ServiceDTO findIdDTO(Long id) {
        Service service = repo.findById(id).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
        return ServiceDTO.fromEntity(service);
    }

    public List<ServiceDTO> findServicesByBarbershopIdAndServiceActiveTrue(Long id) {
        List<Service> services = repo.findServicesByBarbershopIdAndServiceActiveTrue(id);
        return services.stream().map(ServiceDTO::fromEntity).toList();
    }

    public List<ServiceDTO> newDto(List<NewServiceDTO> listDto){
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
        return list.stream().map(ServiceDTO::fromEntity).toList();
    }

    public ServiceDTO updateDto(Long id, UpdateServiceDTO obj) {
        Service updateObj = getById(id);
        updateObj.setServiceDescription(obj.getServiceDescription());
        updateObj.setDuration(obj.getDuration());
        updateObj.setValue(obj.getValue());
        updateObj.setServiceCategory(obj.getServiceCategory());
        repo.save(updateObj);
        return ServiceDTO.fromEntity(updateObj);
    }

    @Override
    public void delete(Long id){
        Service obj = repo.findById(id).orElse(null);
        obj.setServiceActive(false);
        repo.save(obj);
    }


}

