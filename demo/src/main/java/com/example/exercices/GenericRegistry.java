package com.example.exercices;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GenericRegistry <T extends Nameable>{
    private Map<String, T> items = new HashMap<>();

    public void add(T c){
        items.put(c.getName(),c);
    }

    public void listAll(){
        for (T c : items.values()){
            System.out.println(c.getName());
        }
    }

    public T findByName(String name){
        T c = items.get(name);
        if (c == null){
            throw new NotFoundException("Aucun nom renseigné");
        }
        return c;
    }

    public void remove(String name){
        T c = items.get(name);
        if (c == null){
            throw new NotFoundException("Aucun nom renseigné");
        }
        items.remove(name);
    }

    public Collection<T> getAll(){
        return items.values();
    }
}
