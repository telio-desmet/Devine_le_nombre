package su.devinombr;

import java.util.Scanner;
import java.util.Random;

public class Jeu {
    public static void main(String[] args) {
        // Menu du jeu.
        System.out.println("_________________________|Bienvenue dans ce merveilleux jeu de devine le nombre !|_________________________");
        System.out.println("Le but de ce jeu est de deviner le nombre que j'ai en tête, je vais le choisir aléatoirement entre 1 et 100 pour qu'aucune partie ne soit similaire.");
        System.out.println("Le but du jeu est de le deviner ou d'en être le plus proche, vous partez à 100 points et chaque écart vous fera perdre des points, arrivé à 0 c'est perdu !");
        
        // Définition du scanner.
        Scanner scanner = new Scanner(System.in);

        // Générer un nombre aléatoire entre 1 et 100.
        Random rand = new Random();
        int randomNumber = rand.nextInt(100) + 1;
    

        // Initialisation du score.
        int score = 100;
        int userGuess = 0;

        // Boucle du jeu
        while (score > 0) {
            System.out.print("Veuillez choisir un nombre entre 1 et 100 : ");
            userGuess = scanner.nextInt();
            
            // Validation de l'entrée utilisateur
            if (userGuess < 1 || userGuess > 100) {
                System.out.println("Le nombre doit être entre 1 et 100. Veuillez réessayer.");
                continue;
            }

            // Calcul de l'écart
            int difference = Math.abs(randomNumber - userGuess);
            
            // Si l'utilisateur a deviné le bon nombre
            if (userGuess == randomNumber) {
                System.out.println("Félicitations ! Vous avez deviné le bon nombre !");
                break;
            }

            // Mise à jour du score en fonction de l'écart
            score -= difference;
            System.out.println("Mauvais choix ! Vous perdez " + difference + " points. Il vous reste " + score + " points.");

            // Game over
            if (score <= 0) {
                System.out.println("Vous avez perdu. Le nombre correct était : " + randomNumber);
            }
        }

        // Fermeture du scanner
        scanner.close();
    }
}
