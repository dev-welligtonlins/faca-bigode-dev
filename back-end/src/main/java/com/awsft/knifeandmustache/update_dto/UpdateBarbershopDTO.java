package com.awsft.knifeandmustache.update_dto;

import java.util.List;

public class UpdateBarbershopDTO {
    private Long id;
    private String name;
    
    public UpdateBarbershopDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
