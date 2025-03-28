package com.MiamMIa.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int tableNumber; // Numéro de la table
    private List<String> items; // Liste des produits

    // Constructeur avec numéro de table
    public Order(int tableNumber) {
        this.tableNumber = tableNumber;
        this.items = new ArrayList<>();
    }

    // Getter pour tableNumber
    public int getTableNumber() {
        return tableNumber;
    }

    // Setter pour tableNumber
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    // Getter pour items
    public List<String> getItems() {
        return items;
    }

    // Ajouter un produit
    public void addItem(String item) {
        items.add(item);
        System.out.println(item + " ajouté !");
    }

    // Supprimer un produit
    public void removeItem(String item) {
        items.remove(item);
    }

    // Vider la liste de produits
    public void clearItems() {
        items.clear();
    }

    // Méthode pour afficher les détails de la commande
    public String afficherOrder() {
        return "Table: " + getTableNumber() + "\nProduits: " + getItems();
    }

    // Méthode main pour tester la classe
    public static void main(String[] args) {
        Order order = new Order(5);
        order.addItem("Pizza");
        order.addItem("Pâtes");
        order.addItem("Coca-Cola");
        order.afficherOrder();
        order.removeItem("Pâtes");
        System.out.println("Après suppression: " + order.getItems());
        order.clearItems();
        System.out.println("Après avoir vidé la commande: " + order.getItems());
    }
}
