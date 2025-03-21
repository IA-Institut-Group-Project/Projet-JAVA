package com.MiamMIa.model;


public class MenuItem {
    private String name;
    private double price;
    private String category;

    // Constructeur
    public MenuItem(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Getter et Setter pour name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getter et Setter pour price    
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    // Getter et Setter pour category
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}

