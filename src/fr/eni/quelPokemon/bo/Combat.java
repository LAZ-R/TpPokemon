package fr.eni.quelPokemon.bo;

import java.util.Random;
import java.util.Scanner;

public class Combat {

    static Scanner scan = new Scanner(System.in);

    public void pokemon(Pokemon pokemon1, Pokemon pokemon2) {
        if (pokemon2.getDresseur() != null) {
            System.out.printf("%s (%s)%n* VS *%n%s (%s)%n", pokemon1.getNom(), pokemon1.getDresseur().getPrenom(), pokemon2.getNom(), pokemon2.getDresseur().getPrenom());
        }
        else {
            System.out.printf("%s (%s)%n* VS *%n%s (%s)%n", pokemon1.getNom(), pokemon1.getDresseur().getPrenom(), pokemon2.getNom(), "Sauvage");
        }

        System.out.println();
        while (pokemon1.getPv() > 0 && pokemon2.getPv() > 0) {

            // Partie 1 : Pokémon du joueur

            System.out.println("Quelle attaque voulez-vous lancer ?");
            pokemon1.afficherSetAttaques();
            int reponse_utilisateur = scan.nextInt() - 1;

            if (pokemon1.set_attaques[reponse_utilisateur] != null) {
                pokemon1.attaque(pokemon1.set_attaques[reponse_utilisateur], pokemon2);
            }
            else {
                System.out.printf("%s essaye de lancer cette attaque, mais il semble ne pas la connaître%n", pokemon1.getNom());
            }

            // Partie 2 : Pokémon adverse (si il n'est pas mort)

            if (pokemon2.getPv() > 0) {

                Random rand = new Random();
                int attaque_aleatoire = rand.nextInt(4);
                while (pokemon2.set_attaques[attaque_aleatoire] == null) {
                    attaque_aleatoire = rand.nextInt(4);
                }
                pokemon2.attaque(pokemon2.set_attaques[attaque_aleatoire], pokemon1);
            }
        }

        if (pokemon1.getPv() <= 0) {
            System.out.printf("%s est K.O !%n", pokemon1.getNom());
            System.out.println();
        } else {
            System.out.printf("%s est K.O !%n", pokemon2.getNom());
            System.out.println();
        }
    }
}
