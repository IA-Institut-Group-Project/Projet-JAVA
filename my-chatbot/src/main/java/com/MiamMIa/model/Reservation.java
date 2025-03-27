package com.MiamMIa.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Reservation {
    
    private LocalDateTime datetime; // Date et heure
    private int nombreDePersonnes;

    // Constructeur
    public Reservation(LocalDateTime datetime, int nombreDePersonnes) {
        this.datetime = datetime;
        this.nombreDePersonnes = nombreDePersonnes;
    }

    // Getter pour la date
    public LocalDateTime getDate() {
        return datetime;
    }

    // Getter pour le nombre de personnes
    public int getNumber() {
        return nombreDePersonnes;
    }

    // Afficher la réservation
    public String afficherReservation() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return "Réservation : Date et Heure = " + datetime.format(formatter) +
               ", Nombre de personnes = " + nombreDePersonnes;
    }

    // Méthode pour vérifier si la réservation est expirée
    public boolean estExpiree() {
        return datetime.isBefore(LocalDateTime.now());
    }

    // Méthode main pour tester la classe Reservation
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Entrez la date et l'heure (format: dd-MM-yyyy HH:mm) : ");
            String dateStr = scanner.nextLine();
            LocalDateTime date;
            try {
                date = LocalDateTime.parse(dateStr, formatter);
            } catch (Exception e) {
                System.out.println("Erreur de format pour la date. Assurez-vous d'entrer une date valide.");
                return;
            }

            System.out.print("Entrez le nombre de personnes : ");
            int nombreDePersonnes = scanner.nextInt();

            Reservation reservation = new Reservation(date, nombreDePersonnes);
            System.out.println(reservation.afficherReservation());
            System.out.println("Est expirée ? " + reservation.estExpiree());
        } catch (Exception e) {
            System.out.println("Erreur inattendue. Assurez-vous d'entrer des données valides.");
        }
    }
}