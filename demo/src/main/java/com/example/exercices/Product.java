package com.example.exercices;

public class Product implements Nameable{
    private String name;

    public Product(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}
