package com.example.registre;

import java.util.HashMap;
import java.util.Map;

public class ComponentRegistry {
    private Map<String, Component> components = new HashMap<>();

    public void add(Component c){
        components.put(c.getName(),c);
    }

    public void listAll(){
        for (Component c : components.values()){
            System.out.println(c.describe());
        }
    }

    public Component findByName(String name){
        Component c = components.get(name);
        if (c == null){
            throw new ComponentNotFoundException("Aucun nom renseigné");
        }
        return c;
    }

    public void remove(String name){
        Component c = components.get(name);
        if (c == null){
            throw new ComponentNotFoundException("Aucun nom renseigné");
        }
        components.remove(name);
    }
}
