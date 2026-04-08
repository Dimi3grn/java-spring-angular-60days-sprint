package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/components")
public class ComponentController {

    @GetMapping
    public List<String> getComponents() {
        return List.of("Rotor", "Capteur gyroscopique", "Train d'atterrissage");
    }

    // EXERCICE 2 : endpoint GET /components/{name}
    // → retourne une String : "Composant : {name}"
    // Indice 1 : l'annotation sur la méthode prend un paramètre : @GetMapping("/{name}")
    // Indice 2 : pour récupérer {name} depuis l'URL, utilise @PathVariable avant le paramètre
    // Indice 3 : la signature ressemble à → public String getComponent(@___ String name)

    @GetMapping("/{name}")
    public String getComponent(@PathVariable String name) {
        return "composant : " + name;
    }

    // ___ ("/___")
    // public ___ ___(@___ String name) {
    //     return "Composant : " + ___;
    // }
}