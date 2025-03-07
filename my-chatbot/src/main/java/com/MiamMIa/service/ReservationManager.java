package com.MiamMIa.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.MiamMIa.model.Reservation;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReservationManager {

    private static final String CURRENT_RESERVATIONS_FILE = "resources/reservation/current.json";
    private static final String ARCHIVE_RESERVATIONS_FILE = "resources/reservation/archive.json";

    private Gson gson = new Gson();
    private List<Reservation> reservationsEnCours;

    public ReservationManager() {
        // Charger les réservations depuis current.json
        this.reservationsEnCours = loadReservationsFromFile(CURRENT_RESERVATIONS_FILE);
    }

    /**
     * Ajoute une nouvelle réservation et l'enregistre dans current.json.
     */
    public void addReservation(Reservation reservation) {
        reservationsEnCours.add(reservation);
        saveReservationsToFile(CURRENT_RESERVATIONS_FILE, reservationsEnCours);
    }

    /**
     * Affiche les réservations en cours (non expirées).
     */
    public void afficherReservationsEnCours() {
        System.out.println("=== Réservations en cours ===");
        for (Reservation r : reservationsEnCours) {
            if (!r.estExpiree()) {
                System.out.println(r.afficherReservation());
            }
        }
        System.out.println("=============================");
    }

    /**
     * Archive les réservations expirées dans archive.json.
     * Puis met à jour current.json sans les réservations expirées.
     */
    public void archiverReservationsExpirees() {
        // Charger l'archive existante
        List<Reservation> archive = loadReservationsFromFile(ARCHIVE_RESERVATIONS_FILE);

        // Parcourir la liste des réservations en cours et déplacer celles qui sont expirées
        Iterator<Reservation> iterator = reservationsEnCours.iterator();
        while (iterator.hasNext()) {
            Reservation r = iterator.next();
            if (r.estExpiree()) {
                // Ajouter à l'archive
                archive.add(r);
                // Retirer de la liste en cours
                iterator.remove();
            }
        }

        // Sauvegarder l’archive mise à jour
        saveReservationsToFile(ARCHIVE_RESERVATIONS_FILE, archive);

        // Sauvegarder la liste de réservations en cours mise à jour
        saveReservationsToFile(CURRENT_RESERVATIONS_FILE, reservationsEnCours);
    }

    /**
     * Méthode générique de chargement depuis un fichier JSON.
     */
    private List<Reservation> loadReservationsFromFile(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<List<Reservation>>() {}.getType();
            List<Reservation> reservations = gson.fromJson(reader, listType);
            if (reservations == null) {
                reservations = new ArrayList<>();
            }
            return reservations;
        } catch (IOException e) {
            // Fichier inexistant ou erreur de lecture
            return new ArrayList<>();
        }
    }

    /**
     * Méthode générique de sauvegarde dans un fichier JSON.
     */
    private void saveReservationsToFile(String filePath, List<Reservation> reservations) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(reservations, writer);
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier : " + e.getMessage());
        }
    }
}
