import java.security.SecureRandom;
import java.util.Scanner;

public class GenerateurMotDePasse {

    // Constantes : les caractères possibles pour chaque catégorie
    private static final String MAJUSCULES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String MINUSCULES = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHIFFRES = "0123456789";
    private static final String SYMBOLES = "!@#$%^&*()-_=+[]{}";

    // Générateur aléatoire sécurisé (meilleur que Random pour les mots de passe)
    private static final SecureRandom random = new SecureRandom();

   
    public static String genererMotDePasse(int longueur, boolean avecMajuscules,
                                            boolean avecChiffres, boolean avecSymboles) {

        
        StringBuilder caracteresDisponibles = new StringBuilder(MINUSCULES);

        if (avecMajuscules) {
            caracteresDisponibles.append(MAJUSCULES);
        }
        if (avecChiffres) {
            caracteresDisponibles.append(CHIFFRES);
        }
        if (avecSymboles) {
            caracteresDisponibles.append(SYMBOLES);
        }

        // Construction du mot de passe caractère par caractère
        StringBuilder motDePasse = new StringBuilder();
        for (int i = 0; i < longueur; i++) {
            int indexAleatoire = random.nextInt(caracteresDisponibles.length());
            char caractere = caracteresDisponibles.charAt(indexAleatoire);
            motDePasse.append(caractere);
        }

        return motDePasse.toString();
    }

 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- GENERATEUR DE MOT DE PASSE ---");

        System.out.print("Longueur du mot de passe souhaitee : ");
        int longueur = scanner.nextInt();

        if (longueur < 4) {
            System.out.println("La longueur minimale recommandee est 4. Utilisation de 4.");
            longueur = 4;
        }

        System.out.print("Inclure des majuscules ? (o/n) : ");
        boolean avecMajuscules = scanner.next().equalsIgnoreCase("o");

        System.out.print("Inclure des chiffres ? (o/n) : ");
        boolean avecChiffres = scanner.next().equalsIgnoreCase("o");

        System.out.print("Inclure des symboles (!@#...) ? (o/n) : ");
        boolean avecSymboles = scanner.next().equalsIgnoreCase("o");

        String motDePasse = genererMotDePasse(longueur, avecMajuscules, avecChiffres, avecSymboles);

        System.out.println("\nMot de passe genere : " + motDePasse);

        scanner.close();
    }
}
