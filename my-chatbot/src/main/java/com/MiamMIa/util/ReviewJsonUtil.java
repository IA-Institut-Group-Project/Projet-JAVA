package com.MiamMIa.util;

import com.MiamMIa.model.Review;
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

// * ReviewJsonUtil est une classe utilitaire pour lire et écrire des avis au format JSON.
// * Elle utilise la bibliothèque Gson pour la sérialisation et la désérialisation des objets Review.
// * La classe fournit deux méthodes : readReviews pour lire les avis depuis un fichier JSON
// * et writeReviews pour écrire une liste d'avis dans un fichier JSON.

public class ReviewJsonUtil {

    // Lit les avis depuis un fichier JSON
    public static List<Review> readReviews(String fileName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileReader reader = new FileReader(fileName)) {
            Type reviewListType = new TypeToken<List<Review>>() {
            }.getType();
            List<Review> reviews = gson.fromJson(reader, reviewListType);
            return reviews != null ? reviews : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier reviews : " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Écrit la liste des avis dans un fichier JSON
    public static void writeReviews(String fileName, List<Review> reviews) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(reviews, writer);
            System.out.println("Fichier reviews sauvegardé avec succès à : " + new File(fileName).getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier reviews : " + e.getMessage());
        }
    }
}
