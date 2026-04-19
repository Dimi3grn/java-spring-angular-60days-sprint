package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Pilote {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String matricule;

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getMatricule(){
        return this.matricule;
    }
    public void setMatricule(String matricule){
        this.matricule=matricule;
    }

    public Long getId() {
        return id;
    }

    public Pilote(){

    }
}
