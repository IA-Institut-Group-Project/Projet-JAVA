package com.MiamMIa.util;

import com.MiamMIa.model.Reservation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ReservationJsonUtil {

    // Lit les réservations depuis un fichier JSON
    public static List<Reservation> readReservations(String fileName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileReader reader = new FileReader(fileName)) {
            Type reservationListType = new TypeToken<List<Reservation>>() {}.getType();
            List<Reservation> reservations = gson.fromJson(reader, reservationListType);
            return reservations != null ? reservations : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier reservations : " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Écrit la liste des réservations dans un fichier JSON
    public static void writeReservations(String fileName, List<Reservation> reservations) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(reservations, writer);
            System.out.println("Fichier reservations sauvegardé avec succès à : " + new File(fileName).getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier reservations : " + e.getMessage());
        }
    }
}
// * ReservationJsonUtil est une classe utilitaire pour gérer la sérialisation et la désérialisation des objets Reservation.
// * Elle utilise la bibliothèque Gson pour lire et écrire des fichiers JSON contenant des réservations.