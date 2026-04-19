package com.example.demo.service;


import com.example.demo.model.Pilote;
import com.example.demo.repository.PiloteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PiloteService {
    @Autowired
    private PiloteRepository piloteRepository;

    public List<Pilote> getAll(){
        return piloteRepository.findAll();
    }

    public Pilote getById(Long id){
        Optional<Pilote> pilotefound = piloteRepository.findById(id);
        if (pilotefound.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pilot not found by id");
        }
        return pilotefound.get();
    }

    public void add(String name, String matricule){
        Pilote newPilot = new Pilote();
        newPilot.setName(name);
        newPilot.setMatricule(matricule);
        piloteRepository.save(newPilot);
    }

    public void remove(Long id){
        Optional<Pilote> pilotefound = piloteRepository.findById(id);
        if (pilotefound.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pilot not found by id");
        }
        piloteRepository.deleteById(id);
    }
}
