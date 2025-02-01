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

    public String afficherReservation() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return "Réservation : Date et Heure = " + datetime.format(formatter) +
               ", Nombre de personnes = " + nombreDePersonnes;
    }

   // tester
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        try {
            // Demander la date et l'heure
            System.out.print("Entrez la date et l'heure (format: dd-MM-yyyy HH:mm) : ");
            String dateStr = scanner.nextLine();
            LocalDateTime date = LocalDateTime.parse(dateStr, formatter);

            // Demander le nombre de personnes
            System.out.print("Entrez le nombre de personnes : ");
            int nombreDePersonnes = scanner.nextInt();

            // Créer et afficher la réservation
            Reservation reservation = new Reservation(date, nombreDePersonnes);
            System.out.println(reservation.afficherReservation());

        } catch (Exception e) {
            System.out.println("Format invalide. Assurez-vous d'entrer une date valide et un nombre correct.");
        } finally {
            scanner.close();
        }
    }
}

