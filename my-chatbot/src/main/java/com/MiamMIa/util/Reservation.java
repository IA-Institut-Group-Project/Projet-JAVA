import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Reservation {
    
    LocalDateTime datetime; // date et heure
    int nombreDePersonnes;

    // Constructeur
    public Reservation(LocalDateTime datetime, int nombreDePersonnes) {
        this.datetime = datetime;
        this.nombreDePersonnes = nombreDePersonnes;
    }

    // Getters
    public LocalDateTime getDate() {
        return datetime;
    }

    public int getNumber() {
        return nombreDePersonnes;
    }

    // Afficher la réservation
    public String afficherReservation() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return "Réservation : Date et Heure = " + datetime.format(formatter) +
               ", Nombre de personnes = " + nombreDePersonnes;
    }

    // Méthode principale
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        try (Scanner scanner = new Scanner(System.in)) {
            // Demander la date et l'heure
            System.out.print("Entrez la date et l'heure (format: dd-MM-yyyy HH:mm) : ");
            String dateStr = scanner.nextLine();
            LocalDateTime date = null;
            try {
                date = LocalDateTime.parse(dateStr, formatter);
            } catch (Exception e) {
                System.out.println("Erreur de format pour la date. Assurez-vous d'entrer une date valide.");
                return;  // Sortir si la date est invalide
            }

            // Demander le nombre de personnes
            System.out.print("Entrez le nombre de personnes : ");
            int nombreDePersonnes = scanner.nextInt();

            // Créer et afficher la réservation
            Reservation reservation = new Reservation(date, nombreDePersonnes);
            System.out.println(reservation.afficherReservation());

        } catch (Exception e) {
            System.out.println("Erreur inattendue. Assurez-vous d'entrer des données valides.");
        }
    }
}
