package fr.eni.quelPokemon.bo;

import java.util.Random;
import java.util.Scanner;

public class Combat {

    static Scanner scan = new Scanner(System.in);

    public void pokemonSansDresseurs(Pokemon pokemon1, Pokemon pokemon2) {

        System.out.printf("%s (%s)%n* VS *%n%s (%s)%n", pokemon1.getNom(), pokemon1.getDresseur().getPrenom(), pokemon2.getNom(), "Sauvage");

        System.out.println();
        while (pokemon1.getPv() > 0 && pokemon2.getPv() > 0) {

            // Partie 1 : Pokémon du joueur

            System.out.println("Quelle attaque veux-tu lancer ?");
            pokemon1.afficherSetAttaques();
            int reponse_utilisateur = scan.nextInt() - 1;
            scan.nextLine();
            if (reponse_utilisateur < pokemon1.set_attaques.length && reponse_utilisateur >= 0) {
                if (pokemon1.set_attaques[reponse_utilisateur] != null) {
                    pokemon1.attaque(pokemon1.set_attaques[reponse_utilisateur], pokemon2);
                }
            }
            else {
                System.out.printf("%s essaye de lancer cette attaque, mais il semble ne pas la connaître%n%n", pokemon1.getNom());
            }
            System.out.println("(Appuie sur ENTRÉE pour continuer)");
            scan.nextLine();

            // Partie 2 : Pokémon adverse (si il n'est pas mort)

            if (pokemon2.getPv() > 0) {

                Random rand = new Random();
                int attaque_aleatoire = rand.nextInt(4);
                while (pokemon2.set_attaques[attaque_aleatoire] == null) {
                    attaque_aleatoire = rand.nextInt(4);
                }
                pokemon2.attaque(pokemon2.set_attaques[attaque_aleatoire], pokemon1);
            }
            else {
                break;
            }

            System.out.println("(Appuie sur ENTRÉE pour continuer)");
            scan.nextLine();
        }

        // Après traitement, affiche le nom du pokémon KO

        if (pokemon1.getPv() <= 0) {
            System.out.printf("%s est K.O !%n", pokemon1.getNom());
            System.out.println();
        } else {
            System.out.printf("%s est K.O !%n", pokemon2.getNom());
            System.out.println();
        }
        System.out.println("(Appuie sur ENTRÉE pour continuer)");
        scan.nextLine();
    }

    public void pokemonAvecDresseurs(Pokemon pokemon1, Pokemon pokemon2) {

        System.out.printf("%s (%s)%n* VS *%n%s (%s)%n", pokemon1.getNom(), pokemon1.getDresseur().getPrenom(), pokemon2.getNom(), pokemon2.getDresseur().getPrenom());

        System.out.println();
        while (pokemon1.getPv() > 0 && pokemon2.getPv() > 0) {

            // Partie 1 : Pokémon du joueur
            System.out.println("Quelle attaque veux-tu lancer ?");
            pokemon1.afficherSetAttaques();
            int reponse_utilisateur = scan.nextInt() - 1;
            scan.nextLine();
            if (reponse_utilisateur < pokemon1.set_attaques.length && reponse_utilisateur >= 0) {
                if (pokemon1.set_attaques[reponse_utilisateur] != null) {
                    pokemon1.attaque(pokemon1.set_attaques[reponse_utilisateur], pokemon2);
                }
            }
            else {
                System.out.printf("%s essaye de lancer cette attaque, mais il semble ne pas la connaître%n%n", pokemon1.getNom());
            }
            System.out.println("(Appuie sur ENTRÉE pour continuer)");
            scan.nextLine();

            // Partie 2 : Pokémon adverse (si il n'est pas mort)
            if (pokemon2.getPv() > 0) {

                // Choix d'une attaque aléatoire
                Random rand = new Random();
                int attaque_aleatoire = rand.nextInt(4);
                while (pokemon2.set_attaques[attaque_aleatoire] == null) {
                    attaque_aleatoire = rand.nextInt(4);
                }

                pokemon2.attaque(pokemon2.set_attaques[attaque_aleatoire], pokemon1);
            }
            else {
                break;
            }

            System.out.println("(Appuie sur ENTRÉE pour continuer)");
            scan.nextLine();
        }

        // Après traitement, affiche le nom du pokémon KO

        if (pokemon1.getPv() <= 0) {
            System.out.printf("%s est K.O !%n", pokemon1.getNom());
            System.out.println();
        } else {
            System.out.printf("%s est K.O !%n", pokemon2.getNom());
            System.out.println();
        }
        System.out.println("(Appuie sur ENTRÉE pour continuer)");
        scan.nextLine();
    }

    public void dresseurs(Dresseur dresseur1, Dresseur dresseur2) {

        int dresseur1_ok_pokemon = 0;
        for (int i = 0; i < dresseur1.pokemons.length; i++) {
            if (dresseur1.pokemons[i] != null && dresseur1.pokemons[i].getPv() > 0) {
                dresseur1_ok_pokemon += 1;
            }
        }

        int dresseur2_ok_pokemon = 0;
        for (int i = 0; i < dresseur2.pokemons.length; i++) {
            if (dresseur1.pokemons[i] != null && dresseur2.pokemons[i].getPv() > 0) {
                dresseur2_ok_pokemon += 1;
            }
        }

        while (dresseur1_ok_pokemon > 0 && dresseur2_ok_pokemon > 0 ) {

            int dresseur1_nextGoodPoke = 0;
            for (int i = 0; i < dresseur1.pokemons.length; i++) {
                if (dresseur1.pokemons[i].getPv() > 0) {
                    dresseur1_nextGoodPoke = i;
                    break;
                }
            }

            int dresseur2_nextGoodPoke = 0;
            for (int i = 0; i < dresseur2.pokemons.length; i++) {
                if (dresseur2.pokemons[i].getPv() > 0) {
                    dresseur2_nextGoodPoke = i;
                    break;
                }
            }

            pokemonAvecDresseurs(dresseur1.pokemons[dresseur1_nextGoodPoke], dresseur2.pokemons[dresseur2_nextGoodPoke]);

            dresseur1_ok_pokemon = 0;
            for (int i = 0; i < dresseur1.pokemons.length; i++) {
                if (dresseur1.pokemons[i] != null && dresseur1.pokemons[i].getPv() > 0) {
                    dresseur1_ok_pokemon += 1;
                }
            }

            dresseur2_ok_pokemon = 0;
            for (int i = 0; i < dresseur2.pokemons.length; i++) {
                if (dresseur2.pokemons[i] != null && dresseur2.pokemons[i].getPv() > 0) {
                    dresseur2_ok_pokemon += 1;
                }
            }

        }

        if (dresseur1_ok_pokemon <= 0) {
            System.out.printf("%s n'as plus de Pokémons !%n%s a perdu !%n", dresseur1.getPrenom(), dresseur1.getPrenom());
        }
        else {
            System.out.printf("%s n'as plus de Pokémons !%n%s a perdu !%n", dresseur2.getPrenom(), dresseur2.getPrenom());
        }

    }
}
