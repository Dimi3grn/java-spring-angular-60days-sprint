package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class ComponentRequest {
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }

    @NotBlank
    private String name;
}
