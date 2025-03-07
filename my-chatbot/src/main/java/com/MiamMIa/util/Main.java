package com.miammia.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Pour lire les entrées de l'utilisateur
        boolean running = true;
        while (running) {
            System.out.println("Bienvenue chez MiamMia ! Que souhaitez-vous faire ?");
            System.out.println("1. Donner un avis");
            System.out.println("2. Passer une commande");
            System.out.println("3. Faire une réservation de table");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne après nextInt()
            switch (choix) { // Effectuer une action en fonction du choix de l'utilisateur
                case 1:
                    donnerAvis(scanner);
                    break;
                case 2:
                    passerCommande(scanner);
                    break;
                case 3:
                    faireReservation(scanner);
                    break;
                case 4:
                    running = false;
                    System.out.println("Merci et à bientôt chez MiamMia !");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
        scanner.close();
    }

    private static void donnerAvis(Scanner scanner) { // fonction pour donner un avis
        System.out.println("=== Donner un avis ===");
        System.out.print("Votre nom : ");
        String nom = scanner.nextLine();
        System.out.print("Votre commentaire : ");
        String commentaire = scanner.nextLine();
        System.out.print("Votre note (sur 5) : ");
        int note = scanner.nextInt();
        scanner.nextLine(); 
        if (note < 0 || note > 5) { // Vérifier que la note est entre 0 et 5
            System.out.println("La note doit être comprise entre 0 et 5.");
        } else {
            // Enregistrer l'avis 
            System.out.println("Merci pour votre avis, " + nom + " !");
        }

        Review review = new Review(nom, commentaire, note); // Créer un objet Review
        System.out.println(review.afficherReview());
    }

    private static void passerCommande(Scanner scanner) { // fonction pour passer une commande
        System.out.println("=== Passer une commande ===");
        System.out.print("Numéro de table : ");
        int tableNumber = scanner.nextInt();
        scanner.nextLine(); 

        Order order = new Order(tableNumber); // Créer une commande pour une table donnée

        // Ajouter des produits
        String item;
        while (true) { // Demander les produits jusqu'à ce que l'utilisateur saisisse "fin"
            System.out.print("Ajouter un produit (ou 'fin' pour terminer) : ");
            item = scanner.nextLine();
            if (item.equals("fin")) { 
                break;
            }
            order.addItem(item);
        }

        System.out.println(order.afficherOrder());
    }

    private static void faireReservation(Scanner scanner) { // fonction pour faire une réservation
        System.out.println("=== Faire une réservation de table ===");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"); 

        // Demander la date et l'heure
        System.out.print("Entrez la date et l'heure (format: dd-MM-yyyy HH:mm) : ");
        String dateStr = scanner.nextLine();
        LocalDateTime date = LocalDateTime.parse(dateStr, formatter);

        // Demander le nombre de personnes
        System.out.print("Entrez le nombre de personnes : ");
        int nombreDePersonnes = scanner.nextInt();
        scanner.nextLine(); 

        // Créer la réservation
        Reservation reservation = new Reservation(date, nombreDePersonnes); // Créer un objet Reservation
        System.out.println(reservation.afficherReservation());
    }
}
