package com.example.demo.repository;

import com.example.demo.model.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ComponentRepository extends JpaRepository<Component, Long> {
    Component findByName(String name);
    /*private List<String> components = new ArrayList<>(List.of("rotor", "capteur gyroscopique", "train d'atterrissage"));

    public List<String> getAll(){
        return components;
    }

    public String getByName(String name){
        if (!components.contains(name)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Component name NOT FOUDN");
        }
        return name;
    }

    public void add(String name){
        components.add(name);
    }

    public void remove(String name){
        if (!components.contains(name)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Component name NOT FOUDN");
        }
        components.remove(name);
    }

    public void rename(String original, String newValue){
        if (!components.contains(original)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Component name NOT FOUDN");
        }
        components.set(components.indexOf(original), newValue);
    }*/
}
