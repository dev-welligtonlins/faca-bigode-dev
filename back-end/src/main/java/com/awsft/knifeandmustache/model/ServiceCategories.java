package com.awsft.knifeandmustache.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_categories")
public class ServiceCategories {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "service_categories_description")
    private String description;

    @OneToMany
    @JoinColumn(name = "services")
    private List<Services> services = new ArrayList<Services>();

    public ServiceCategories(){ 

    }

    public ServiceCategories(String description) {
        this.description = description;
    }

    // GET
    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    // SET
    public void setDescription(String description) {
        this.description = description;
    }

    

}