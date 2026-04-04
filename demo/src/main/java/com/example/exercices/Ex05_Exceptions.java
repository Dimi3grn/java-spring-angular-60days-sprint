package com.example.exercices;

// EXERCICE 5 — Exceptions
// Objectif : gérer les erreurs proprement en Java
//
// En Go, tu gères les erreurs comme ça :
//   result, err := doSomething()
//   if err != nil { return err }
//
// En Java, le mécanisme est différent : les exceptions sont des objets
// qui "remontent" la pile d'appels jusqu'à être attrapées.
//
// Deux types d'exceptions en Java :
//   - Checked   : le compilateur t'OBLIGE à les gérer (ex: IOException)
//   - Unchecked : runtime, pas obligatoire (ex: NullPointerException, IllegalArgumentException)

public class Ex05_Exceptions {

    // --- PARTIE 1 : Lancer une exception ---

    // Cette méthode valide le poids d'un composant
    // Si le poids est invalide, elle lance une exception
    public static double validateWeight(double weight) {

        // 1. Si weight <= 0, lance une IllegalArgumentException
        //    Syntaxe : throw new IllegalArgumentException("message");
        if (weight <= 0) {
            throw new IllegalArgumentException("Le poids doit être positif, reçu : " + weight);
        }
        return weight;
    }

    // --- PARTIE 2 : Créer une exception personnalisée ---

    // 2. Crée une classe InvalidComponentException qui étend RuntimeException
    //    (RuntimeException = unchecked, pas besoin de la déclarer partout)
    static class InvalidComponentException extends RuntimeException {
        public InvalidComponentException(String message) {
            super(message);   // appelle le constructeur de RuntimeException
        }
    }

    // Cette méthode valide un nom de composant
    public static String validateName(String name) {
        // 3. Si name est null OU vide, lance une InvalidComponentException
        if (name == null || name.isEmpty()) {
            throw new InvalidComponentException("Le nom ne peut pas être vide");
        }
        return name;
    }

    // --- PARTIE 3 : Attraper les exceptions ---

    public static void main(String[] args) {

        // 4. try-catch de base
        //    Syntaxe :
        //    try {
        //        // code risqué
        //    } catch (TypeException e) {
        //        // gestion de l'erreur
        //    }
        try {
            double weight = validateWeight(-5.0);
            System.out.println("Poids valide : " + weight);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());  // getMessage() retourne le message
        }

        // 5. try-catch avec finally
        //    Le bloc "finally" s'exécute TOUJOURS, erreur ou pas
        //    (utile pour fermer des ressources — base de données, fichiers)
        try {
            String name = validateName("");
            System.out.println("Nom valide : " + name);
        } catch (InvalidComponentException e) {
            System.out.println("Erreur composant : " + e.getMessage());
        } finally {
            System.out.println("Bloc finally — toujours exécuté");
        }

        // 6. Attraper plusieurs exceptions
        try {
            validateWeight(10.0);
            validateName(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur poids : " + e.getMessage());
        } catch (InvalidComponentException e) {
            System.out.println("Erreur nom : " + e.getMessage());
        }

        // QUESTION BONUS :
        // Que se passe-t-il si tu ne catches PAS une exception ?
        // Décommente la ligne suivante et observe :
    }
}
