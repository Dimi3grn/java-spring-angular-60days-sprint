package com.example.demo.service;

import com.example.demo.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentService {
    @Autowired
    private ComponentRepository componentRepository;

    public List<String> getAll(){
        return componentRepository.getAll();
    }

    public String getByName(String name){
        return componentRepository.getByName(name);
    }

    public void add(String name){
        componentRepository.add(name);
    }

    public void remove(String name){
        componentRepository.remove(name);
    }

    public void rename(String original, String newValue){
        componentRepository.rename(original, newValue);
    }

}
