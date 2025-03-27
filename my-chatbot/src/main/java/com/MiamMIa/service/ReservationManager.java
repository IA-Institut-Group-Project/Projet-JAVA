package com.MiamMIa.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.MiamMIa.model.Reservation;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReservationManager {

    // Chemin du fichier contenant les réservations en cours
    private static final String CURRENT_RESERVATIONS_FILE = "resources/reservation/current.json";

    // Instance de Gson pour la sérialisation et la désérialisation des objets JSON
    private Gson gson = new Gson();

    // Liste des réservations en cours
    private List<Reservation> reservationsEnCours;

    // Constructeur pour initialiser les réservations en cours à partir du fichier
    // JSON
    public ReservationManager() {
        // Charge les réservations existantes depuis le fichier
        this.reservationsEnCours = loadReservationsFromFile(CURRENT_RESERVATIONS_FILE);
    }

    // Méthode pour ajouter une nouvelle réservation
    public void addReservation(Reservation reservation) {
        reservationsEnCours.add(reservation); // Ajoute la réservation à la liste
        // Sauvegarde la liste mise à jour dans le fichier JSON
        saveReservationsToFile(CURRENT_RESERVATIONS_FILE, reservationsEnCours);
    }

    // Méthode pour afficher les réservations en cours qui ne sont pas expirées
    public void afficherReservationsEnCours() {
        System.out.println("=== Réservations en cours ===");

        // Définition du format pour la date de réservation
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime now = LocalDateTime.now(); // Récupère l'heure actuelle

        // Parcours toutes les réservations en cours
        for (Reservation r : reservationsEnCours) {
            try {
                // Parse la date de la réservation à partir de la chaîne de caractères
                LocalDateTime reservationDate = LocalDateTime.parse(r.getDate(), formatter);

                // Vérifie si la réservation n'est pas dans le passé
                if (!reservationDate.isBefore(now)) {
                    // Affiche les informations de la réservation
                    System.out.println(r.afficherReservation());
                }
            } catch (Exception e) {
                // Affiche une erreur si le format de la date est incorrect
                System.out.println("Erreur de parsing de la date pour une réservation : " + e.getMessage());
            }
        }
        System.out.println("=============================");
    }

    // Méthode pour supprimer les réservations expirées
    public void supprimerReservationsExpirees() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime now = LocalDateTime.now(); // Récupère l'heure actuelle

        // Utilise un itérateur pour supprimer les éléments pendant l'itération
        Iterator<Reservation> iterator = reservationsEnCours.iterator();
        while (iterator.hasNext()) {
            Reservation r = iterator.next();
            try {
                // Parse la date de la réservation à partir de la chaîne de caractères
                LocalDateTime reservationDate = LocalDateTime.parse(r.getDate(), formatter);

                // Si la date de réservation est dans le passé, supprime la réservation
                if (reservationDate.isBefore(now)) {
                    iterator.remove();
                }
            } catch (Exception e) {
                // Affiche une erreur si le format de la date est incorrect
                System.out.println("Erreur de parsing de la date pour une réservation : " + e.getMessage());
            }
        }

        // Sauvegarde la liste mise à jour dans le fichier JSON
        saveReservationsToFile(CURRENT_RESERVATIONS_FILE, reservationsEnCours);
    }

    // Méthode pour charger les réservations depuis un fichier JSON
    private List<Reservation> loadReservationsFromFile(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            // Définit le type de la liste pour la désérialisation JSON
            Type listType = new TypeToken<List<Reservation>>() {
            }.getType();
            // Désérialise le contenu du fichier JSON en liste de réservations
            List<Reservation> reservations = gson.fromJson(reader, listType);
            // Retourne les réservations ou une liste vide si aucune donnée n'est trouvée
            return (reservations != null) ? reservations : new ArrayList<>();
        } catch (IOException e) {
            // Retourne une liste vide en cas d'erreur de lecture (par exemple, fichier
            // inexistant)
            return new ArrayList<>();
        }
    }

    // Méthode pour sauvegarder les réservations dans un fichier JSON
    private void saveReservationsToFile(String filePath, List<Reservation> reservations) {
        try (FileWriter writer = new FileWriter(filePath)) {
            // Sérialise la liste de réservations et l'écrit dans le fichier JSON
            gson.toJson(reservations, writer);
        } catch (IOException e) {
            // Affiche une erreur en cas de problème lors de l'écriture dans le fichier
            System.out.println("Erreur lors de l'écriture du fichier : " + e.getMessage());
        }
    }
}
