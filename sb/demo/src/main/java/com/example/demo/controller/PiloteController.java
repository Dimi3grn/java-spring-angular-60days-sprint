package com.example.demo.controller;


import com.example.demo.dto.PiloteRequest;
import com.example.demo.model.Pilote;
import com.example.demo.service.ComponentService;
import com.example.demo.service.PiloteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pilotes")
public class PiloteController {
    @Autowired
    private PiloteService piloteService;

    @GetMapping
    public List<Pilote> getPilots(){
        return piloteService.getAll();
    }

    @GetMapping("/{id}")
    public Pilote getPilot(@PathVariable Long id){
        return piloteService.getById(id);
    }

    @PostMapping()
    public void addPilote(@RequestBody @Valid PiloteRequest request){
        piloteService.add(request.getName(), request.getMatricule());
    }

    @DeleteMapping("/{id}")
    public void deletePilote(@PathVariable Long id){
        piloteService.remove(id);
    }
}
