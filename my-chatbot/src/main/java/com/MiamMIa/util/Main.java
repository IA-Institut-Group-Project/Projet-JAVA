import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Bienvenue chez MiamMia ! Que souhaitez-vous faire ?");
            System.out.println("1. Donner un avis");
            System.out.println("2. Passer une commande");
            System.out.println("3. Faire une réservation de table");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne après nextInt()
            switch (choix) {
                case 1:
                    donnerAvis(scanner);
                    break;
                case 2:
                    passerCommande(scanner);
                    break;
                case 3:
                    faireReservation(scanner);
                    break;
                case 4:
                    running = false;
                    System.out.println("Merci et à bientôt chez MiamMia !");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
        scanner.close();
    }

    private static void donnerAvis(Scanner scanner) {
        System.out.println("=== Donner un avis ===");
        System.out.print("Votre nom : ");
        String nom = scanner.nextLine();
        System.out.print("Votre commentaire : ");
        String commentaire = scanner.nextLine();
        System.out.print("Votre note (sur 5) : ");
        int note = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne après nextInt()
        if (note < 0 || note > 5) {
            System.out.println("La note doit être comprise entre 0 et 5.");
        } else {
            // Enregistrer l'avis (à implémenter plus tard)
            System.out.println("Merci pour votre avis, " + nom + " !");
        }
    }

    private static void passerCommande(Scanner scanner) {
        System.out.println("=== Passer une commande ===");
        System.out.print("Numéro de table : ");
        int tableNumber = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne après nextInt()
        // Logique pour passer une commande (à implémenter plus tard)
        System.out.println("Commande passée pour la table " + tableNumber + ".");
    }

    private static void faireReservation(Scanner scanner) {
        System.out.println("=== Faire une réservation de table ===");
        System.out.print("Date (dd/MM/yyyy) : ");
        String date = scanner.nextLine();
        System.out.print("Heure (HH:mm) : ");
        String heure = scanner.nextLine();
        System.out.print("Nombre de personnes : ");
        int nombreDePersonnes = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne après nextInt()
        // Logique pour enregistrer la réservation (à implémenter plus tard)
        System.out.println(
                "Réservation effectuée pour " + nombreDePersonnes + " personnes le " + date + " à " + heure + ".");
    }
}
