package com.example.registre;

public abstract class Component {
    protected String name;
    protected double weight;

    public Component (String name,double weight){
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight(){
        return weight;
    }

    public abstract String describe();
}


