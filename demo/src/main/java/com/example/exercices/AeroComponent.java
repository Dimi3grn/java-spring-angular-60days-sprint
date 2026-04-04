package com.example.exercices;

// EXERCICE 1 — Classe de base et encapsulation
// Objectif : créer une classe AeroComponent avec des attributs privés et des getters
//
// En Go tu écrirais :
//   type AeroComponent struct {
//       name      string
//       weight    float64
//       certified bool
//   }
//
// En Java, les attributs sont "private" par convention — on n'y accède pas directement.
// On passe par des méthodes appelées "getters".

// 1. Déclare la classe (le nom doit correspondre au nom du fichier !)
public class AeroComponent {

    // 2. Déclare les 3 attributs en "private"
    //    Syntaxe : private <type> <nom>;
    private String name;
    private double weight;
    private boolean certified;

    // 3. Constructeur — appelé quand on fait "new AeroComponent(...)"
    //    Syntaxe : public NomDeLaClasse(paramètres) { ... }
    public AeroComponent(String name, double weight, boolean certified) {
        // "this.name" = l'attribut de la classe
        // "name"      = le paramètre reçu
        this.name = name;
        this.weight = weight;
        this.certified = certified;
    }

    // 4. Getters — méthodes publiques pour lire les attributs privés
    //    Syntaxe : public <type> get<Nom>() { return this.<attribut>; }
    public String getName() {
        return this.name;
    }

    public double getWeight() {
        return this.weight;
    }

    public boolean isCertified() {   // convention : "is" au lieu de "get" pour les boolean
        return this.certified;
    }

    // 5. Méthode describe() — retourne une String lisible
    //    Comme fmt.Sprintf en Go
    public String describe() {
        return "Composant: " + this.name + " | Poids: " + this.weight + "kg | Certifié: " + this.certified;
    }

    // 6. Point d'entrée
    public static void main(String[] args) {

        // Crée un premier composant : "Rotor principal", 45.5 kg, certifié
        AeroComponent c1 = new AeroComponent("Rotor principal", 45.5, true);

        // Crée un deuxième composant : "Pale de queue", 12.3 kg, non certifié
        AeroComponent c2 = new AeroComponent("Pale de queue", 12.3, false);

        // Affiche les deux composants avec describe()
        System.out.println(c1.describe());
        System.out.println(c2.describe());
    }
}
