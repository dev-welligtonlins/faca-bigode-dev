package com.awsft.knifeandmustache.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.awsft.knifeandmustache.model.ServiceCategories;
import com.awsft.knifeandmustache.repository.ServiceCategoriesRepository;

@Service
public class ServiceCategoriesService implements ICrud<ServiceCategories>{

    private final ServiceCategoriesRepository repo;
  
    public ServiceCategoriesService(ServiceCategoriesRepository repo){
        this.repo = repo;
    }

    public ServiceCategories save(ServiceCategories obj){
        return repo.save(obj);
    }

    // Retorna todos registros da classe. 
    @Override
    public List<ServiceCategories> findAll(){
        return repo.findAll();
    }
    
    // Retorna um registro da classe.
    public ServiceCategories getById(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id){
        ServiceCategories obj = repo.findById(id).orElse(null);
        repo.delete(obj);
    }
}
