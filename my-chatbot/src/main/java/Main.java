package com.miammi.chatbot;

import com.MiamMIa.model.Review;
import com.MiamMIa.model.Order;
import com.MiamMIa.model.Reservation;
import com.MiamMIa.util.OrderJsonUtil;
import com.MiamMIa.util.ReservationJsonUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        boolean running = true;
        while (running) {
            System.out.println("Bienvenue chez MiamMia ! Que souhaitez-vous faire ?");
            System.out.println("1. Donner un avis");
            System.out.println("2. Passer une commande");
            System.out.println("3. Faire une réservation de table");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); 
            switch (choix) {
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

    private static void donnerAvis(Scanner scanner) {
        System.out.println("=== Donner un avis ===");
        System.out.print("Votre nom : ");
        String nom = scanner.nextLine();
        System.out.print("Votre commentaire : ");
        String commentaire = scanner.nextLine();
        System.out.print("Votre note (sur 5) : ");
        int note = scanner.nextInt();
        scanner.nextLine();
        if (note < 0 || note > 5) {
            System.out.println("La note doit être comprise entre 0 et 5.");
        } else {
            System.out.println("Merci pour votre avis, " + nom + " !");
        }
        Review review = new Review(nom, commentaire, note);
        System.out.println(review.afficherReview());
    }

    private static void passerCommande(Scanner scanner) {
        System.out.println("=== Passer une commande ===");
        System.out.print("Numéro de table : ");
        int tableNumber = scanner.nextInt();
        scanner.nextLine();

        Order order = new Order(tableNumber);
        String item;
        while (true) {
            System.out.print("Ajouter un produit (ou 'fin' pour terminer) : ");
            item = scanner.nextLine();
            if (item.equalsIgnoreCase("fin")) {
                break;
            }
            order.addItem(item);
        }
        System.out.println(order.afficherOrder());
        
        // Enregistrer la commande dans le fichier "orders.json"
        String ordersFile = "orders.json";
        List<Order> orders = OrderJsonUtil.readOrders(ordersFile);
        orders.add(order);
        OrderJsonUtil.writeOrders(ordersFile, orders);
        System.out.println("Commande enregistrée avec succès !");
    }

    private static void faireReservation(Scanner scanner) {
        System.out.println("=== Faire une réservation de table ===");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        System.out.print("Entrez la date et l'heure (format: dd-MM-yyyy HH:mm) : ");
        String dateStr = scanner.nextLine();
        LocalDateTime date = LocalDateTime.parse(dateStr, formatter);

        System.out.print("Entrez le nombre de personnes : ");
        int nombreDePersonnes = scanner.nextInt();
        scanner.nextLine();

        Reservation reservation = new Reservation(date, nombreDePersonnes);
        System.out.println(reservation.afficherReservation());
        
        // Enregistrer la réservation dans le fichier "reservations.json"
        String reservationsFile = "reservations.json";
        List<Reservation> reservations = ReservationJsonUtil.readReservations(reservationsFile);
        reservations.add(reservation);
        ReservationJsonUtil.writeReservations(reservationsFile, reservations);
        System.out.println("Réservation enregistrée avec succès !");
    }
}

