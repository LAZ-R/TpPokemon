package fr.eni.quelPokemon.bo;

import java.util.Random;
import java.util.Scanner;

/** Classe qui represente un combat
 *
 * @author laz_R
 * @version 1.0
 */
public class Combat {

    // Déclaration des instances
    static Scanner scan = new Scanner(System.in);

    /** Méthode qui régit la façon dont deux pokémons s'affrontent.
     *
     * @param pokemon1 Pokemon
     * @param pokemon2 Pokemon
     */
    public void pokemon(Pokemon pokemon1, Pokemon pokemon2) {

        // Le premier affichage dépends de si le pokémon affronté appartient à un dresseur, ou si il est sauvage
        if (pokemon2.getDresseur() != null) {
            System.out.printf("%s (%s)%n[%d/%dpv]%n* VS *%n%s (%s)%n[%d/%dpv]%n", pokemon1.getNom(), pokemon1.getDresseur().getPrenom(), pokemon1.getPv(), pokemon1.getPvMax(), pokemon2.getNom(), pokemon2.getDresseur().getPrenom(), pokemon2.getPv(), pokemon2.getPvMax());
        }
        else {
            System.out.printf("%s (%s)%n[%d/%dpv]%n* VS *%n%s (%s)%n[%d/%dpv]%n", pokemon1.getNom(), pokemon1.getDresseur().getPrenom(), pokemon1.getPv(), pokemon1.getPvMax(), pokemon2.getNom(), "Sauvage", pokemon2.getPv(), pokemon2.getPvMax());
        }
        System.out.println();

        // Boucle tant qu'un des deux pokémons n'est pas mort
        while (pokemon1.getPv() > 0 && pokemon2.getPv() > 0) {

            // Partie 1 : Tour du Pokémon du joueur

            // Choix de l'attaque à lancer parmis celles disponibles
            System.out.println("Quelle attaque veux-tu lancer ?");
            pokemon1.afficherSetAttaques();
            // La réponse de l'utilisateur servira pour parcourir le tableau, donc on lui enlève 1
            int reponse_utilisateur = scan.nextInt() - 1;
            scan.nextLine();

            // Si la réponse de l'utilisateur est bien dans le tableau et que la case du tableau n'est pas nulle
            if (reponse_utilisateur < pokemon1.set_attaques.length && reponse_utilisateur >= 0 && pokemon1.set_attaques[reponse_utilisateur] != null) {
                    // le pokémon du joueur appelle la méthode attaque() sur le pokemon adverse
                    pokemon1.attaque(pokemon1.set_attaques[reponse_utilisateur], pokemon2);
                }
            // Sinon le Pokémon essaye de lancer une attaque qui n'existe pas
            else {
                System.out.printf("%s essaye de lancer cette attaque, mais il semble ne pas la connaître%n%n", pokemon1.getNom());
            }

            System.out.println("(Appuie sur ENTRÉE pour continuer)");
            scan.nextLine();

            // Partie 2 : Tour du Pokémon adverse (si il n'est pas mort pendant la partie 1)
            if (pokemon2.getPv() > 0) {

                // Choix d'une attaque aléatoire
                Random rand = new Random();
                int attaque_aleatoire = rand.nextInt(4);

                // Boucle tant que l'aléatoire tombe sur une case non attribuée du tableau d'attaque
                while (pokemon2.set_attaques[attaque_aleatoire] == null) {
                    attaque_aleatoire = rand.nextInt(4);
                }
                // le pokémon adverse appelle la méthode attaque() sur le pokemon du joueur
                pokemon2.attaque(pokemon2.set_attaques[attaque_aleatoire], pokemon1);
            }
            // Si le pokémon adverse est mort pendant la partie 1, sort de la boucle
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

    /** Méthode qui régit la façon dont deux dresseurs s'affrontent.
     *
     * @param dresseur1 Dresseur
     * @param dresseur2 Dresseur
     */
    public void dresseurs(Dresseur dresseur1, Dresseur dresseur2) {

        // On détermine d'abord le nombre de pokémons "valides" (non KO) du dresseur 1
        int dresseur1_ok_pokemon = 0;
        // Pour chaque case du tableau de pokémon du dresseur 1
        for (int i = 0; i < dresseur1.pokemons.length; i++) {
            // Si cette case n'est pas null et que le pokémon qui l'occupe a encore des pv
            if (dresseur1.pokemons[i] != null && dresseur1.pokemons[i].getPv() > 0) {
                // on incrémente son nombre de pokémons ok
                dresseur1_ok_pokemon += 1;
            }
        }

        // Puis on détermine le nombre de pokémons "valides" (non KO) du dresseur 2
        int dresseur2_ok_pokemon = 0;
        for (int i = 0; i < dresseur2.pokemons.length; i++) {
            if (dresseur1.pokemons[i] != null && dresseur2.pokemons[i].getPv() > 0) {
                dresseur2_ok_pokemon += 1;
            }
        }

        // Pendant que les deux dresseurs ont encore au moins 1 pokémon valide
        while (dresseur1_ok_pokemon > 0 && dresseur2_ok_pokemon > 0 ) {

            // On détermine le premier pokémon valide dans le tableau de pokémon du dresseur 1
            int dresseur1_nextGoodPoke = 0;
            // Pour chaque case du tableau de pokémon du dresseur 1
            for (int i = 0; i < dresseur1.pokemons.length; i++) {
                // Si le pokémon n'est pas mort
                if (dresseur1.pokemons[i].getPv() > 0) {
                    // on récupère son index
                    dresseur1_nextGoodPoke = i;
                    // et on sort !
                    break;
                }
            }

            // Pareil pour le dresseur 2
            int dresseur2_nextGoodPoke = 0;
            for (int i = 0; i < dresseur2.pokemons.length; i++) {
                if (dresseur2.pokemons[i].getPv() > 0) {
                    dresseur2_nextGoodPoke = i;
                    break;
                }
            }

            // Les 2 pokémons valides les plus hauts dans le tableau de chaque joueur s'affrontent
            pokemon(dresseur1.pokemons[dresseur1_nextGoodPoke], dresseur2.pokemons[dresseur2_nextGoodPoke]);

            // Vérification du nombre de pokémons valides dans chaque équipe avant de re-boucler
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

        // Affichage du perdant par "manque de pokémons valides"
        if (dresseur1_ok_pokemon <= 0) {
            System.out.printf("%s n'as plus de Pokémons !%n%s a perdu !%n", dresseur1.getPrenom(), dresseur1.getPrenom());
        }
        else {
            System.out.printf("%s n'as plus de Pokémons !%n%s a perdu !%n", dresseur2.getPrenom(), dresseur2.getPrenom());
        }
    }
}
