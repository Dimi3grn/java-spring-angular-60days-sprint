package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Component {

    @Id
    @GeneratedValue
    private Long id ;

    @NotBlank
    @NotNull
    @Column(nullable = false, length = 255)
    private String name;

    public Component(){

    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public Long getId(){
        return this.id;
    }
}
