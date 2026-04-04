package com.example.registre;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ComponentRegistry registry = new ComponentRegistry();

        while (true){
            System.out.println("=== Registre Aéronautique ===");
            System.out.println("1. Ajouter un composant");
            System.out.println("2. Lister tous les composants");
            System.out.println("3. Chercher par nom");
            System.out.println("4. Supprimer un composant");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");

            // lecture des inputs
            String input = scanner.nextLine(); // lit une ligne

            switch (input){
                case "1":
                    System.out.println("=== Registre Aéronautique ===");
                    System.out.println("Nom de votre composant :");
                    String addinputName = scanner.nextLine();
                    System.out.print("Poids (kg) : ");
                    String addInputPoids = scanner.nextLine();
                    double poids = Double.parseDouble(addInputPoids);
                    System.out.println("=== Registre Aéronautique ===");
                    System.out.println("Type de votre composant :");
                    System.out.println("1- Mécanique");
                    System.out.println("2- Electrique");
                    String addinputType = scanner.nextLine();
                    switch (addinputType){
                        case "1":
                            System.out.println("Max Rpm : ");
                            String addinputMaxRPM = scanner.nextLine();
                            double maxRPM = Double.parseDouble(addinputMaxRPM);
                            MechanicalComponent newwMech = new MechanicalComponent(addinputName, poids, maxRPM);
                            registry.add(newwMech);
                            break;
                        case "2":
                            System.out.println("Max Voltage : ");
                            String addinputMaxVoltage = scanner.nextLine();
                            double maxVoltage = Double.parseDouble(addinputMaxVoltage);
                            ElectricalComponent newElec = new ElectricalComponent(addinputName, poids, maxVoltage);
                            registry.add(newElec);
                            break;
                    }
                    break;
                case "2":
                    registry.listAll();
                    break;

                case "3":
                    System.out.println("=== Registre Aéronautique ===");
                    System.out.println("Nom de votre composant :");
                    String nameSearch = scanner.nextLine();

                    try{
                        Component found = registry.findByName(nameSearch);
                        System.out.println(found.describe());
                    }catch (ComponentNotFoundException error){
                        System.out.println("Erreur : " + error.getMessage());
                    }
                    break;

                case "4":
                    System.out.println("=== Registre Aéronautique ===");
                    System.out.println("Nom de votre composant :");
                    String nameRemove = scanner.nextLine();

                    try {
                        registry.remove(nameRemove);
                    }catch (ComponentNotFoundException error){
                        System.out.println("Erreur : " + error.getMessage());
                    }
                    break;

                case "5":
                    System.exit(0);
            }
        }
    }

}
