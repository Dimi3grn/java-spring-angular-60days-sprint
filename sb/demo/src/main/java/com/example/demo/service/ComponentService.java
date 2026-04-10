package com.example.demo.service;

import com.example.demo.model.Component;
import com.example.demo.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentService {
    @Autowired
    private ComponentRepository componentRepository;

    public List<Component> getAll(){
        return componentRepository.findAll();
    }

    public Component getByName(String name){
        return componentRepository.findByName(name);
    }

    public void add(String name){
        Component named = new Component();
        named.setName(name);
        componentRepository.save(named);
    }


    public void remove(String name){
        componentRepository.delete(componentRepository.findByName(name));
    }

    public void rename(String original, String newValue){
        Component c = componentRepository.findByName(original);
        c.setName(newValue);
        componentRepository.save(c);
    }

}
