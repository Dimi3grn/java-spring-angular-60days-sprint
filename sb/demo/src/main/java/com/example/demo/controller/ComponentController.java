package com.example.demo.controller;

import com.example.demo.dto.ComponentRequest;
import com.example.demo.model.Component;
import com.example.demo.service.ComponentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/components")
public class ComponentController {
    @Autowired
    private ComponentService componentService;

    // J7 - EXERCICE 1 : liste partagée entre toutes les méthodes
    // Problème actuel : getComponents() et getComponent() n'ont pas accès à la même liste
    // Solution : déclarer la liste comme attribut de la classe
    // Indice : ArrayList est modifiable (List.of est figée)



    @GetMapping
    public List<Component> getComponents() {
        return componentService.getAll();
    }

    @GetMapping("/{id}")
    public Component getComponent(@PathVariable Long id) {
        return componentService.getById(id);
    }

    // J7 - EXERCICE 3 : POST /components → ajouter un composant
    // Le client envoie un texte brut dans le corps de la requête (ex: "Altimètre")
    // La méthode l'ajoute à la liste et retourne la liste mise à jour
    // Indice Spring : @PostMapping sur la méthode, @RequestBody sur le paramètre

    @PostMapping()
    public void addComponent(@RequestBody @Valid ComponentRequest request) {
        componentService.add(request.getName());
    }

    @DeleteMapping("/{id}")
    public void removeComponent(@PathVariable Long id){
        componentService.remove(id);
    }

    @PutMapping("/{id}")
    public void renameComponent(@PathVariable Long id, @RequestBody String newName){
        componentService.rename(id, newName);
    }

    @GetMapping("/search")
    public List<Component> searchComponent(@RequestParam("keyword") String keyword){
        return componentService.search(keyword);
    }

    @GetMapping("/sorted")
    public List<Component> sortComponents(){
        return componentService.sort();
    }

}