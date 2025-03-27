
package com.MiamMIa.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.MiamMIa.model.Order;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//* OrderManager Class
//  * This class manages the orders in the MiamMia application.
//  * It provides methods to add, display, and archive orders.
//  * The orders are stored in JSON files for persistence.
public class OrderManager {

    private static final String COMMANDES_FILE = "resources/commandes.json";
    private static final String ARCHIVE_COMMANDES_FILE = "resources/archive_commandes.json";

    private Gson gson = new Gson();
    private List<Order> commandesEnCours;

    public OrderManager() {
        // Charger les commandes depuis commandes.json
        this.commandesEnCours = loadOrdersFromFile(COMMANDES_FILE);
    }

    /**
     * Ajoute une commande et l'enregistre dans commandes.json.
     */
    public void addOrder(Order order) {
        commandesEnCours.add(order);
        saveOrdersToFile(COMMANDES_FILE, commandesEnCours);
    }

    /**
     * Affiche toutes les commandes en cours.
     */
    public void afficherCommandesEnCours() {
        System.out.println("=== Commandes en cours ===");
        for (Order o : commandesEnCours) {
            System.out.println(o.afficherOrder());
        }
        System.out.println("==========================");
    }

    /**
     * Archive une commande "finalisée" dans archive_commandes.json.
     * @param orderTableNumber le numéro de table pour identifier la commande à finaliser.
     */
    public void archiverCommande(int orderTableNumber) {
        // Charger l'archive existante
        List<Order> archive = loadOrdersFromFile(ARCHIVE_COMMANDES_FILE);

        // Parcourir la liste des commandes en cours et déplacer celle qui correspond au numéro de table
        Iterator<Order> iterator = commandesEnCours.iterator();
        while (iterator.hasNext()) {
            Order o = iterator.next();
            if (o.getTableNumber() == orderTableNumber) {
                // Ajouter à l'archive
                archive.add(o);
                // Retirer de la liste en cours
                iterator.remove();
                break;
            }
        }

        // Sauvegarder l’archive mise à jour
        saveOrdersToFile(ARCHIVE_COMMANDES_FILE, archive);
        // Sauvegarder la liste de commandes en cours mise à jour
        saveOrdersToFile(COMMANDES_FILE, commandesEnCours);
    }

    /**
     * Méthode générique de chargement depuis un fichier JSON.
     */
    private List<Order> loadOrdersFromFile(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<List<Order>>() {}.getType();
            List<Order> orders = gson.fromJson(reader, listType);
            if (orders == null) {
                orders = new ArrayList<>();
            }
            return orders;
        } catch (IOException e) {
            // Fichier inexistant ou erreur de lecture
            return new ArrayList<>();
        }
    }

    /**
     * Méthode générique de sauvegarde dans un fichier JSON.
     */
    private void saveOrdersToFile(String filePath, List<Order> orders) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(orders, writer);
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier : " + e.getMessage());
        }
    }
}
