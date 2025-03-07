package com.MiamMIa.model;

import java.util.Scanner;

public class Review {

    String clientName;
    String comment;
    int rating;

    public Review(String clientName, String comment, int rating) {
        this.clientName = clientName;
        this.comment = comment;
        setRating(rating);
    }

    public String getClientName() {
        return clientName;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Le rating doit être entre 0 et 5");
        }
        this.rating = rating;
    }

    public String afficherReview() {
        return "Nom du client: " + clientName + "\n" +
                "Commentaire: " + comment + "\n" +
                "Note: " + rating + "/5";
    }

    // Méthode principale
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            //
            System.out.print("Votre nom : ");
            String clientName = scanner.nextLine();

            //
            System.out.print("Votre commentaire : ");
            String comment = scanner.nextLine();

            //
            System.out.print("Entrez une note (0 à 5) : ");
            int rating = scanner.nextInt();

            //
            Review review = new Review(clientName, comment, rating);

            // resultat
            System.out.println("\nDétails de l'avis :");
            System.out.println(review.afficherReview());

        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Format invalide. Assurez-vous d'entrer une note correcte.");
        } finally {
            scanner.close();
        }
    }
}
