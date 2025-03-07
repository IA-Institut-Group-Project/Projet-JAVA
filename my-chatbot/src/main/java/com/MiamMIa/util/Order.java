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
        String details = "Table: " + getTableNumber() + "\nProduits: " + getItems();
        System.out.println(details);
        return details;
    }

    // Méthode main pour tester la classe
    public static void main(String[] args) {
        // Créer une commande pour la table 5
        Order order = new Order(5);

        // Ajouter des produits
        order.addItem("Pizza");
        order.addItem("Pâtes");
        order.addItem("Coca-Cola");

        // Afficher les détails de la commande
        order.afficherOrder();

        // Retirer un produit
        order.removeItem("Pâtes");
        System.out.println("Produits après suppression: " + order.getItems());

        // Vider la commande
        order.clearItems();
        System.out.println("Produits après avoir vidé la commande: " + order.getItems());
    }
}
