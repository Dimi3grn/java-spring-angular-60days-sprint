package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class PiloteRequest {
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getMatricule(){ return this.matricule;}
    public void setMatricule(String matricule){ this.matricule= matricule;}

    @NotBlank
    private String name;

    @NotBlank
    private String matricule;
}
