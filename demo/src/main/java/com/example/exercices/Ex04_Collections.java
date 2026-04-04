package com.example.exercices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// EXERCICE 4 — Collections : List et Map
// Objectif : manipuler les structures de données les plus utilisées en Java
//
// En Go :
//   []string          → List<String> en Java
//   map[string]int    → Map<String, Integer> en Java
//
// Différence clé : en Java on utilise les types "boxés" pour les génériques
//   int     → Integer
//   double  → Double
//   boolean → Boolean
//   (String reste String)

public class Ex04_Collections {

    public static void main(String[] args) {

        // ============================================================
        // PARTIE 1 — ArrayList (liste dynamique, comme un slice Go)
        // ============================================================

        // 1. Crée une liste de composants (String)
        //    Syntaxe : List<Type> nom = new ArrayList<>();
        List<String> components = new ArrayList<>();

        // 2. Ajoute 3 composants avec .add()
        components.add("Roue");
        components.add("Turbine");
        components.add("Altimètre");

        // 3. Affiche la taille de la liste avec .size()
        System.out.println("Nombre de composants : " + components.size());

        // 4. Parcours avec une boucle for-each
        //    Syntaxe : for (Type element : collection) { ... }
        for (String component : components) {
            System.out.println("- " + component);
        }

        // 5. Vérifie si la liste contient "Turbine" avec .contains()
        System.out.println("Contient Turbine : " + components.contains("Turbine"));

        // 6. Supprime "Altimètre" avec .remove()
        components.remove("Altimètre");
        System.out.println("Après suppression : " + components);

        System.out.println("---");

        // ============================================================
        // PARTIE 2 — HashMap (clé → valeur, comme map en Go)
        // ============================================================

        // 7. Crée une map : nom du composant → poids (double)
        //    Syntaxe : Map<TypeClé, TypeValeur> nom = new HashMap<>();
        Map<String, Double> weights = new HashMap<>();

        // 8. Ajoute 3 entrées avec .put(clé, valeur)
        weights.put("Rotor", 45.5);
        weights.put("Turbine", 80.0);
        weights.put("Vis", 0.5);

        // 9. Récupère une valeur avec .get(clé)
        System.out.println("Poids du Rotor : " + weights.get("Rotor"));

        // 10. Parcours de la map avec entrySet()
        //     entry.getKey() = la clé, entry.getValue() = la valeur
        for (Map.Entry<String, Double> entry : weights.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue() + "kg");
        }

        // 11. Vérifie si une clé existe avec .containsKey()
        System.out.println("Contient GPS : " + weights.containsKey("GPS"));
        System.out.println(weights.get("Moteur"));

        // ============================================================
        // QUESTION BONUS :
        // Que se passe-t-il si tu fais weights.get("Moteur") ? ca retournerais rien
        // (une clé qui n'existe pas)
        // Teste-le et dis-moi ce que Java retourne.
        // ============================================================
    }
}
