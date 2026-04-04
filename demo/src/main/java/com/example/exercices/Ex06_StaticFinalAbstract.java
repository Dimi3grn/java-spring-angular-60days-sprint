package com.example.exercices;

// EXERCICE 6 — static, final, et classes abstraites
// Objectif : comprendre les 3 derniers piliers du Java Core
//
// - static  : appartient à la CLASSE, pas à une instance
// - final   : ne peut pas être modifié (variable) ou redéfini (méthode/classe)
// - abstract: classe incomplète qui FORCE les enfants à implémenter certaines méthodes
//
// Analogie abstract vs interface :
//   Interface      = contrat pur, pas de code, pas d'attributs
//   Classe abstraite = contrat PARTIEL — du code commun + des méthodes à implémenter

// ============================================================
// PARTIE 1 — static
// ============================================================

class ComponentRegistry {

    // Variable static = partagée entre TOUTES les instances
    // C'est un compteur global — peu importe combien d'objets tu crées,
    // il y a UN SEUL compteur
    private static int count = 0;

    private String name;

    public ComponentRegistry(String name) {
        this.name = name;
        // 1. Incrémente le compteur à chaque création d'objet
        count++;
    }

    // 2. Méthode static pour lire le compteur
    //    static car elle n'a pas besoin d'une instance pour fonctionner
    public static int getCount() {
        return count;
    }

    public String getName() { return name; }
}

// ============================================================
// PARTIE 2 — final
// ============================================================

class AircraftConstants {

    // Constante : static (appartient à la classe) + final (immuable)
    // Convention : MAJUSCULES_AVEC_UNDERSCORES
    public static final double MAX_WEIGHT_KG = 50000.0;
    public static final String CERTIFICATION_STANDARD = "DO-178C";

    // 3. Déclare une constante MAX_ALTITUDE_M de type int valant 15000
    public static final int MAX_ALTITUDE_M = 15000;
}

class FinalDemo {

    // final sur un attribut = ne peut être assigné qu'une seule fois (dans le constructeur)
    private final String serialNumber;

    public FinalDemo(String serialNumber) {
        this.serialNumber = serialNumber;   // OK — première assignation
    }

    public String getSerialNumber() { return serialNumber; }

    // final sur une méthode = ne peut pas être @Override dans une classe enfant
    public final String getInfo() {
        return "Série : " + serialNumber;
    }
}

// ============================================================
// PARTIE 3 — Classe abstraite
// ============================================================

// Une classe abstraite ne peut pas être instanciée directement
// Elle peut avoir : des attributs, des méthodes concrètes, ET des méthodes abstraites
// 4. Déclare cette classe comme abstraite
abstract class AeroVehicle {

    protected String model;     // protected = accessible aux classes enfants
    protected double maxSpeed;

    public AeroVehicle(String model, double maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    // Méthode concrète — partagée par tous les enfants
    public String getInfo() {
        return model + " (vitesse max: " + maxSpeed + " km/h)";
    }

    // 5. Méthode abstraite — les enfants DOIVENT l'implémenter
    //    Syntaxe : public abstract <type> <nom>();
    public abstract String takeoff();
    public abstract String land();
}

// 6. Implémente Helicopter qui étend AeroVehicle
class Helicopter extends AeroVehicle {

    private int rotorCount;

    public Helicopter(String model, double maxSpeed, int rotorCount) {
        super(model, maxSpeed);
        this.rotorCount = rotorCount;
    }

    // 7. Implémente takeoff() et land()
    @Override
    public String takeoff() {
        return model + " décolle verticalement avec " + rotorCount + " rotor(s)";
    }

    @Override
    public String land() {
        return model + " atterrit verticalement";
    }
}

// 8. Implémente FixedWingAircraft qui étend AeroVehicle
class FixedWingAircraft extends AeroVehicle {

    private double runwayLength;

    public FixedWingAircraft(String model, double maxSpeed, double runwayLength) {
        super(model, maxSpeed);
        this.runwayLength = runwayLength;
    }

    @Override
    public String takeoff() {
        return model + " décolle après " + runwayLength + "m de piste";
    }

    @Override
    public String land() {
        return model + " atterrit sur " + runwayLength + "m de piste";
    }
}

// ============================================================
// POINT D'ENTRÉE
// ============================================================
public class Ex06_StaticFinalAbstract {

    public static void main(String[] args) {

        // --- static ---
        ComponentRegistry r1 = new ComponentRegistry("Rotor");
        ComponentRegistry r2 = new ComponentRegistry("Turbine");
        ComponentRegistry r3 = new ComponentRegistry("GPS");

        // 9. Affiche le nombre total de composants créés
        //    Appelle getCount() sur la CLASSE, pas sur une instance
        System.out.println("Composants créés : " + ComponentRegistry.getCount());

        // --- final ---
        System.out.println("Poids max : " + AircraftConstants.MAX_WEIGHT_KG + " kg");
        System.out.println("Standard : " + AircraftConstants.CERTIFICATION_STANDARD);
        System.out.println("Altitude max : " + AircraftConstants.MAX_ALTITUDE_M);

        // --- abstract ---
        Helicopter h = new Helicopter("EC135", 254.0, 2);
        FixedWingAircraft f = new FixedWingAircraft("Rafale", 1912.0, 400.0);

        // 10. Affiche getInfo(), takeoff() et land() pour les deux véhicules
        System.out.println(h.getInfo());
        System.out.println(h.takeoff());
        System.out.println(h.land());

        System.out.println(f.getInfo());
        System.out.println(f.takeoff());
        System.out.println(f.land());

        // QUESTION BONUS :
        // Pourquoi ce code est-il invalide ?
        // AeroVehicle v = new AeroVehicle("Test", 100.0);
        // Décommente, observe l'erreur, explique. 
        // ON NE PEUT PAS APPELLER UNE CLASSE ABSTRAITE, UNIQUEMENT SES ENFANTS 
    }
}
