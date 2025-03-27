package com.MiamMIa.util;

import com.MiamMIa.model.Order;
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

// * OrderJsonUtil est une classe utilitaire pour lire et écrire des commandes au format JSON.
// * Elle utilise la bibliothèque Gson pour la sérialisation et la désérialisation des objets Order.

public class OrderJsonUtil {

    // Lit les commandes depuis un fichier JSON
    public static List<Order> readOrders(String fileName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileReader reader = new FileReader(fileName)) {
            Type orderListType = new TypeToken<List<Order>>() {
            }.getType();
            List<Order> orders = gson.fromJson(reader, orderListType);
            return orders != null ? orders : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier orders : " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Écrit la liste des commandes dans un fichier JSON
    public static void writeOrders(String fileName, List<Order> orders) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(orders, writer);
            System.out.println("Fichier orders sauvegardé avec succès à : " + new File(fileName).getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier orders : " + e.getMessage());
        }
    }
}
