package com.MiamMIa.model;

import java.util.Scanner;

public class Reservation {

    private String datetime; // Date et heure stockées en String
    private int nombreDePersonnes;

    // Constructeur
    public Reservation(String datetime, int nombreDePersonnes) {
        this.datetime = datetime;
        this.nombreDePersonnes = nombreDePersonnes;
    }

    // Getter pour la date
    public String getDate() {
        return datetime;
    }

    // Getter pour le nombre de personnes
    public int getNumber() {
        return nombreDePersonnes;
    }

    // Afficher la réservation
    public String afficherReservation() {
        return "Réservation : Date et Heure = " + datetime +
                ", Nombre de personnes = " + nombreDePersonnes;
    }

    // Méthode main pour tester la classe Reservation
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Entrez la date et l'heure (format: dd-MM-yyyy HH:mm) : ");
            String dateStr = scanner.nextLine();

            System.out.print("Entrez le nombre de personnes : ");
            int nombreDePersonnes = scanner.nextInt();

            Reservation reservation = new Reservation(dateStr, nombreDePersonnes);

            System.out.println(reservation.afficherReservation());
        } catch (Exception e) {
            System.out.println("Erreur inattendue. Assurez-vous d'entrer des données valides.");
        }
    }
}

// * Reservation est une classe qui représente une réservation de table dans un
// restaurant.
// * Elle contient des attributs pour la date et l'heure de la réservation,
// ainsi que le nombre de personnes.
// * La classe fournit des méthodes pour afficher la réservation et pour
// récupérer les informations de réservation.
