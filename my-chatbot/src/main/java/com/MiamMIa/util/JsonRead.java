package util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.MiamMIa.model.MenuItem;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonRead {
    public static void main(String[] args) {
        
        // nom du fichier JSON
        String fileName = "current.json";

        // Créer un objet Gson
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(fileName)) {
            
            Type menuListType = new TypeToken<List<MenuItem>>(){}.getType();

            // Lire et désérialiser le fichier JSON
            List<MenuItem> menu = gson.fromJson(reader, menuListType);

            // Afficher les éléments du menu
            System.out.println("Menu chargé depuis le fichier JSON :");
            for (MenuItem item : menu) {
                System.out.println(item.getName() + " - " + item.getPrice() + "€ - " + item.getCategory());
            }
        
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
}
