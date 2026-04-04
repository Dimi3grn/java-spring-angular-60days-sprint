package com.example.exercices;

// EXERCICE 2 — Héritage et polymorphisme
// Objectif : comprendre "extends" et la surcharge de méthodes
//
// Contexte : un composant aéronautique peut être soit une pièce mécanique,
// soit un composant électronique. Les deux partagent des attributs communs
// mais ont des comportements spécifiques.
//
// En Go tu ferais de la composition :
//   type ElectronicComponent struct {
//       AeroComponent          // composition
//       voltage float64
//   }
//
// En Java on peut faire de l'héritage :
//   class ElectronicComponent extends AeroComponent { ... }

// --- CLASSE PARENTE ---
class Component {

    // Attributs communs à tous les composants
    private String name;
    private double weight;

    public Component(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName()      { return this.name; }
    public double getWeight()    { return this.weight; }

    // Méthode que les enfants pourront REDÉFINIR
    // Le mot-clé pour redéfinir en Java s'appelle "override"
    public String describe() {
        return "Composant: " + this.name + " (" + this.weight + "kg)";
    }
}

// --- CLASSE ENFANT 1 ---
// 1. Fais hériter MechanicalComponent de Component
class MechanicalComponent extends Component {

    private int maxRPM;

    // 2. Constructeur — appelle le constructeur parent avec "super(...)"
    //    C'est obligatoire quand le parent n'a pas de constructeur vide
    public MechanicalComponent(String name, double weight, int maxRPM) {
        super(name, weight);       // appel du constructeur parent
        this.maxRPM = maxRPM;
    }

    public int getMaxRPM() { return this.maxRPM; }

    // 3. Redéfinis describe() pour ajouter les infos mécaniques
    //    L'annotation @Override indique qu'on redéfinit une méthode parente
    @Override
    public String describe() {
        // Astuce : tu peux appeler la méthode parente avec super.describe()
        return super.describe() + " | Mécanique | RPM max: " + this.maxRPM;
    }
}

// --- CLASSE ENFANT 2 ---
// 4. Fais hériter ElectronicComponent de Component
class ElectronicComponent extends Component {

    private double voltage;

    public ElectronicComponent(String name, double weight, double voltage) {
        super(name, weight);
        this.voltage = voltage;
    }

    // 5. Redéfinis describe() pour afficher la tension
    @Override
    public String describe() {
        return super.describe() + " | Électronique | Tension: " + this.voltage + "V";
    }
}

// --- POINT D'ENTRÉE ---
public class Ex02_Heritage {

    public static void main(String[] args) {

        // 6. Crée un composant mécanique : "Turbine", 80.0 kg, 12000 RPM
        MechanicalComponent turbine = new MechanicalComponent("turbine", 80, 12000);

        // 7. Crée un composant électronique : "Capteur GPS", 0.5 kg, 5.0 V
        ElectronicComponent gps = new ElectronicComponent("Capteur GPS", 0.5, 5.0);

        // 8. Affiche les deux avec describe()
        System.out.println(turbine.describe());
        System.out.println(gps.describe());

        // 9. QUESTION BONUS — ce code est-il valide ? Pourquoi ?
        Component c = new MechanicalComponent("Test", 1.0, 500);
        System.out.println(c.describe());
        //    Décommente-le, teste-le, et explique ce qui se passe.
    }
}
