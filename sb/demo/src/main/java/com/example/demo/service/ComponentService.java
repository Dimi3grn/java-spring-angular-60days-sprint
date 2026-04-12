package com.example.demo.service;

import com.example.demo.model.Component;
import com.example.demo.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ComponentService {
    @Autowired
    private ComponentRepository componentRepository;

    public List<Component> getAll(){
        return componentRepository.findAll();
    }

    public Component getById(Long id){
        Optional<Component> variable = componentRepository.findById(id);
        if (variable.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Component name NOT FOUND");
        }
        return variable.get();
    }

    public Component getByName(String name){
        Component variable = componentRepository.findByName(name);
        if (variable == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Component name NOT FOUND");
        }
        return variable;
    }

    public void add(String name){
        Component named = new Component();
        named.setName(name);
        componentRepository.save(named);
    }


    public void remove(Long id){
        Optional<Component> variable = componentRepository.findById(id);
        if (variable.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Component name NOT FOUND");
        }
        componentRepository.deleteById(id);
    }

    public void rename(Long id, String newValue){
        Optional<Component> variable = componentRepository.findById(id);
        if (variable.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Component name NOT FOUND");
        }
        variable.get().setName(newValue);
        componentRepository.save(variable.get());
    }

}
