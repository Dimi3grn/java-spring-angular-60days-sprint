package com.example.exercices;

// EXERCICE 3 — Interfaces
// Objectif : comprendre la différence entre héritage et interface
//
// En Go, tu n'as QUE des interfaces (pas de classes abstraites, pas d'héritage).
// En Java, les interfaces existent aussi — mais elles sont plus strictes :
//   - Pas d'attributs (sauf constantes)
//   - Que des signatures de méthodes (le contrat)
//   - Une classe peut implémenter PLUSIEURS interfaces (contrairement à extends)
//
// Analogie : extends = "est un". implements = "sait faire".
//   Un drone EST un véhicule (extends)
//   Un drone SAIT voler ET SAIT communiquer (implements)

// --- INTERFACES ---

// 1. Déclare l'interface Flyable avec une méthode fly() qui retourne une String
interface Flyable {
    String fly();   // pas de corps, juste la signature
}

// 2. Déclare l'interface Measurable avec une méthode getMeasure() qui retourne un double
interface Measurable {
    double getMeasure();
}

// --- CLASSES ---

// 3. Drone implémente Flyable ET Measurable
//    Syntaxe : class Drone implements Interface1, Interface2
class Drone implements Flyable, Measurable {

    private String model;
    private double altitude;

    public Drone(String model, double altitude) {
        this.model = model;
        this.altitude = altitude;
    }

    // 4. Implémente fly()
    @Override
    public String fly() {
        return this.model + " vole à " + this.altitude + "m";
    }

    // 5. Implémente getMeasure() — retourne l'altitude
    @Override
    public double getMeasure() {
        return this.altitude;
    }
}

// 6. Capteur implémente uniquement Measurable
class Sensor implements Measurable {

    private String type;
    private double value;

    public Sensor(String type, double value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public double getMeasure() {
        return this.value;
    }

    public String getType() { return this.type; }
}

// --- POINT D'ENTRÉE ---
public class Ex03_Interfaces {

    // 7. Cette méthode accepte N'IMPORTE QUEL objet qui implémente Measurable
    //    C'est la puissance des interfaces : on ne sait pas ce qu'on reçoit,
    //    on sait juste qu'il a getMeasure()
    public static void printMeasure(Measurable m) {
        System.out.println("Mesure : " + m.getMeasure());
    }

    public static void main(String[] args) {

        Drone drone = new Drone("MQ-9 Reaper", 15000.0);
        Sensor sensor = new Sensor("Altimètre", 3500.5);

        // 8. Appelle fly() sur le drone
        System.out.println(drone.fly());

        // 9. Appelle printMeasure() avec le drone ET avec le capteur
        //    Les deux types différents passent dans la même méthode — pourquoi ? car ils l'ont tout les 1
        printMeasure(drone);
        printMeasure(sensor);

        // 10. QUESTION BONUS :
        //     Flyable f = new Drone("Test", 100.0);
        //     f.getMeasure(); // valide ou pas ?
        //     Décommente, teste, explique.
    }
}
