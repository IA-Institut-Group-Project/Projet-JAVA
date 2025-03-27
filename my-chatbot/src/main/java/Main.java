package com.miammi.chatbot;

import com.MiamMIa.model.Review;
import com.MiamMIa.model.Order;
import com.MiamMIa.model.Reservation;
import com.MiamMIa.util.OrderJsonUtil;
import com.MiamMIa.util.ReservationJsonUtil;
import com.MiamMIa.util.ReviewJsonUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

//* MiamMia Chatbot Main Class
//  * This class serves as the entry point for the MiamMia chatbot application.
//  * It provides a command-line interface for users to interact with the chatbot,
//  * allowing them to give reviews, place orders, and make reservations.
//  *
//  * @author MiamMia Team
//  * @version 1.0
public class Main {

    // * Main method to run the MiamMia chatbot application.
    // * It presents a menu to the user and handles their choices.
    public static void main(String[] args) {

        // * Create a Scanner object for user input.
        // * The Scanner is used to read input from the console.
        Scanner scanner = new Scanner(System.in);
        // * Print a welcome message to the user.
        // * This message is displayed when the application starts.
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
        // * Close the Scanner object to free up resources.
        // * This is important to prevent resource leaks.
        scanner.close();
    }

    // * Method to handle user reviews.
    // * It prompts the user for their name, comment, and rating,
    // * and saves the review to a JSON file.
    private static void donnerAvis(Scanner scanner) {
        System.out.println("=== Donner un avis ===");
        System.out.print("Votre nom : ");
        String nom = scanner.nextLine();
        System.out.print("Votre commentaire : ");
        String commentaire = scanner.nextLine();

        // Validation de la note
        // La note doit être un entier entre 0 et 5
        // Si la note est invalide, on redemande à l'utilisateur de saisir une note
        // valide
        // On utilise une boucle pour continuer à demander jusqu'à ce qu'une note valide
        // soit saisie
        int note;
        while (true) {
            System.out.print("Votre note (sur 5) : ");
            note = scanner.nextInt();
            scanner.nextLine();
            if (note < 0 || note > 5) {
                System.out.println("La note doit être comprise entre 0 et 5. Veuillez réessayer.");
            } else {
                break;
            }
        }
        // Afficher un message de remerciement à l'utilisateur
        // On utilise la méthode afficherReview() de la classe Review pour afficher les
        // détails de l'avis
        System.out.println("Merci pour votre avis, " + nom + " !");
        Review review = new Review(nom, commentaire, note);

        // Charger les avis existants, ajouter le nouveau et sauvegarder
        List<Review> reviews = ReviewJsonUtil.readReviews("reviews.json");
        reviews.add(review);
        ReviewJsonUtil.writeReviews("reviews.json", reviews);

        System.out.println(review.afficherReview());
    }

    // * Method to handle placing an order.
    // * It prompts the user for the table number and items to order,
    // * and saves the order to a JSON file.
    private static void passerCommande(Scanner scanner) {
        System.out.println("=== Passer une commande ===");
        System.out.print("Numéro de table : ");
        int tableNumber = scanner.nextInt();
        scanner.nextLine();
        Order order = new Order(tableNumber);
        boolean ordering = true;
        while (ordering) {
            System.out.println("Sélectionnez une catégorie :");
            System.out.println("1. Plats");
            System.out.println("2. Desserts");
            System.out.println("3. Boissons");
            System.out.println("4. Terminer la commande");
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    ajouterProduit(scanner, order, "Plats", new String[] { "Pizza", "Burger", "Pâtes" });
                    break;
                case 2:
                    ajouterProduit(scanner, order, "Desserts", new String[] { "Tarte", "Glace", "Mousse au chocolat" });
                    break;
                case 3:
                    ajouterProduit(scanner, order, "Boissons", new String[] { "Eau", "Soda", "Jus d'orange" });
                    break;
                case 4:
                    ordering = false;
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
        System.out.println("\n" + order.afficherOrder() + "\n");
        List<Order> orders = OrderJsonUtil.readOrders("orders.json");
        orders.add(order);
        OrderJsonUtil.writeOrders("orders.json", orders);
        System.out.println("Commande enregistrée avec succès !");
    }

    private static void ajouterProduit(Scanner scanner, Order order, String categorie, String[] produits) {
        System.out.println("=== " + categorie + " ===");
        for (int i = 0; i < produits.length; i++) {
            System.out.println((i + 1) + ". " + produits[i]);
        }
        System.out.println("0. Retour au menu principal");
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();
        scanner.nextLine();
        if (choix > 0 && choix <= produits.length) {
            order.addItem(produits[choix - 1]);
            System.out.println(produits[choix - 1] + " ajouté à la commande.");
        }
    }

    // * Method to handle table reservations.
    // * It prompts the user for the date, time, and number of people,
    // * and saves the reservation to a JSON file.
    // * The date and time are expected in the format "dd-MM-yyyy HH:mm".
    private static void faireReservation(Scanner scanner) {
        System.out.println("=== Faire une réservation de table ===");
        // Méthode pour gérer la réservation de table, incluant l'affichage des horaires
        // et leur vérification
        // Affichage des plages horaires d'ouverture
        System.out.println();
        System.out.println(
                "Veuillez consulter les horaires d'ouverture du restaurant et saisir votre réservation en respectant le format indiqué :");
        System.out.println("Lundi     : Fermé");
        System.out.println("Mardi     : 12:00 - 14:30 | 19:00 - 22:00");
        System.out.println("Mercredi  : 12:00 - 14:30 | 19:00 - 22:00");
        System.out.println("Jeudi     : 12:00 - 14:30 | 19:00 - 22:00");
        System.out.println("Vendredi  : 12:00 - 14:30 | 19:00 - 23:00");
        System.out.println("Samedi    : 12:00 - 14:30 | 19:00 - 23:00");
        System.out.println("Dimanche  : 12:00 - 14:30 | 19:00 - 22:00");
        System.out.println();

        System.out.print("Entrez la date et l'heure (format: dd-MM-yyyy HH:mm) : ");
        String dateStr = scanner.nextLine();

        System.out.print("Entrez le nombre de personnes : ");
        int nombreDePersonnes = scanner.nextInt();
        scanner.nextLine();
        System.out.println("");
        Reservation reservation = new Reservation(dateStr, nombreDePersonnes);
        System.out.println(reservation.afficherReservation());
        System.out.println("");
        // Enregistrer la réservation dans le fichier "reservations.json"
        String reservationsFile = "current.json";
        List<Reservation> reservations = ReservationJsonUtil.readReservations(reservationsFile);
        reservations.add(reservation);
        ReservationJsonUtil.writeReservations(reservationsFile, reservations);
        System.out.println("Réservation enregistrée avec succès !");
    }
}