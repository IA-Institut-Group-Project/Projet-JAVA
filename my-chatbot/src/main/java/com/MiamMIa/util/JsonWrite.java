package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.MiamMIa.model.MenuItem;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//* JsonWrite Class
//  * This class is responsible for writing a list of menu items to a JSON file.
//  * It uses the Gson library to convert Java objects into JSON format.
public class JsonWrite {
    public static void main(String[] args) {
        List<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem("Pizza Margherita", 8.5, "Plats"));
        menu.add(new MenuItem("Salade César", 5.0, "Entrées"));

        // Créer un objet Gson
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(menu); // Convertir la liste en JSON

        // sauvegarder dans un fichier JSON
        try (FileWriter writer = new FileWriter("menu.json")) {
            writer.write(json);
            System.out.println("Fichier JSON sauvegardé avec succès.");
        } catch (IOException e) {
            System.out.println("Erreur lors de la création du fichier :" + e.getMessage());;
        }
    }
}
