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
    }

    // Supprimer un produit
    public void removeItem(String item) {
        items.remove(item);
    }

    // Vider la liste de produits
    public void clearItems() {
        items.clear();
    }
}
