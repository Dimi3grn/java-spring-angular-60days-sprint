package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Component {

    @Id
    @GeneratedValue
    private Long id ;

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
