import java.util.ArrayList;
import java.util.Scanner;

class Depense {

    private final double montant;
    private final String description;
    private final String categorie;

    Depense(double montant, String description, String categorie) {
        this.montant = montant;
        this.description = description;
        this.categorie = categorie;
    }

    public double getMontant() {
        return montant;
    }

    public String getDescription() {
        return description;
    }

    public String getCategorie() {
        return categorie;
    }

    @Override
    public String toString() {
        return String.format("%.2f FCFA | %s | %s", montant, description, categorie);
    }
}

public class GestionDepenses {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Depense> depenses = new ArrayList<>();

    public static void main(String[] args) {

        int choix;

        do {
            afficherMenu();
            choix = lireChoix();

            switch (choix) {
                case 1:
                    creerDepense();
                    break;
                case 2:
                    listerDepenses();
                    break;
                case 3:
                    System.out.println("Total : " + String.format("%.2f", calculerTotal()) + " FCFA");
                    break;
                case 4:
                    calculerTotalParCategorie();
                    break;
                case 5:
                    afficherDepenseMaximum();
                    break;
                case 6:
                    rechercherDepense();
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }

        } while (choix != 0);

        scanner.close();
    }

    // Afficher le menu
    static void afficherMenu() {

        System.out.println("\n===== GESTION DES DEPENSES =====");
        System.out.println("1. Créer une dépense");
        System.out.println("2. Lister les dépenses");
        System.out.println("3. Calculer le total");
        System.out.println("4. Total par catégorie");
        System.out.println("5. Dépense maximum");
        System.out.println("6. Rechercher une dépense");
        System.out.println("0. Quitter");
    }

    // Lire le choix du menu, en rejetant les entrées non numériques
    static int lireChoix() {

        System.out.print("Votre choix : ");

        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide.");
            scanner.next();
            System.out.print("Votre choix : ");
        }

        int choix = scanner.nextInt();
        scanner.nextLine();
        return choix;
    }

    // Lire un montant, en rejetant les entrées non numériques
    static double lireMontant() {

        System.out.print("Montant : ");

        while (!scanner.hasNextDouble()) {
            System.out.println("Veuillez entrer un nombre valide.");
            scanner.next();
            System.out.print("Montant : ");
        }

        double montant = scanner.nextDouble();
        scanner.nextLine();
        return montant;
    }

    // Créer une dépense
    static void creerDepense() {

        double montant = lireMontant();

        if (montant <= 0) {
            System.out.println("Le montant doit être supérieur à 0.");
            return;
        }

        System.out.print("Description : ");
        String description = scanner.nextLine().trim();

        System.out.print("Catégorie : ");
        String categorie = scanner.nextLine().trim();

        if (description.isEmpty() || categorie.isEmpty()) {
            System.out.println("La description et la catégorie ne peuvent pas être vides.");
            return;
        }

        depenses.add(new Depense(montant, description, categorie));
        System.out.println("Dépense créée avec succès.");
    }

    // Lister les dépenses
    static void listerDepenses() {

        if (depenses.isEmpty()) {
            System.out.println("Aucune dépense.");
            return;
        }

        System.out.println("\n===== MES DEPENSES =====");

        for (Depense depense : depenses) {
            System.out.println(depense);
        }
    }

    // Calculer le total
    static double calculerTotal() {

        double total = 0;

        for (Depense depense : depenses) {
            total = total + depense.getMontant();
        }

        return total;
    }

    // Calculer le total par catégorie
    static void calculerTotalParCategorie() {

        if (depenses.isEmpty()) {
            System.out.println("Aucune dépense.");
            return;
        }

        System.out.print("Catégorie : ");
        String categorie = scanner.nextLine().trim();

        double total = 0;

        for (Depense depense : depenses) {
            if (depense.getCategorie().equalsIgnoreCase(categorie)) {
                total = total + depense.getMontant();
            }
        }

        System.out.println("Total de " + categorie + " : " + String.format("%.2f", total) + " FCFA");
    }

    // Afficher la dépense maximum
    static void afficherDepenseMaximum() {

        if (depenses.isEmpty()) {
            System.out.println("Aucune dépense.");
            return;
        }

        Depense maximum = depenses.get(0);

        for (Depense depense : depenses) {
            if (depense.getMontant() > maximum.getMontant()) {
                maximum = depense;
            }
        }

        System.out.println("Dépense maximum :");
        System.out.println(maximum);
    }

    // Rechercher une dépense (recherche partielle, insensible a la casse)
    static void rechercherDepense() {

        if (depenses.isEmpty()) {
            System.out.println("Aucune dépense.");
            return;
        }

        System.out.print("Entrez un mot-clé à rechercher : ");
        String recherche = scanner.nextLine().trim().toLowerCase();

        boolean trouve = false;

        for (Depense depense : depenses) {
            if (depense.getDescription().toLowerCase().contains(recherche)) {
                System.out.println(depense);
                trouve = true;
            }
        }

        if (!trouve) {
            System.out.println("Aucune dépense trouvée.");
        }
    }
}