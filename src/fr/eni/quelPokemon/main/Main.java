package fr.eni.quelPokemon.main;

import fr.eni.quelPokemon.bo.*;

import java.util.Scanner;

/** Classe Main
 *
 * @author laz_R
 * @version 1.0
 */
public class Main {

    static Scanner global_scanner = new Scanner(System.in);
    static HistoireTextes texte = new HistoireTextes();
    static Combat combat = new Combat();
    static CentrePkmn centrePokemon = new CentrePkmn();


    public static void main(String[] args) {

        // Début
        texte.intro_1();

        // Création du joueur
        String nom_joueur = global_scanner.nextLine();
        Dresseur joueur = new Dresseur(nom_joueur);
        System.out.println();

        // Début de l'histoire
        texte.intro_2(joueur.getPrenom());

        // Acquisition du Pikachu
        Attaque statik = new Attaque("Statik", 20);
        Attaque paratonnerre = new Attaque("Paratonnerre", 75);
        Pokemon pikachu = new Pokemon("Pikachu",40,6000,120, statik, paratonnerre, null, null);

        joueur.capture_sansCondition(pikachu);

        System.out.printf("%s recoit un %s !%n",joueur.getPrenom(), pikachu.getNom());
        System.out.println("Félicitation, voici ton premier Pokémon !");
        texte.continuer();

        pikachu.afficher();
        texte.continuer();

        texte.intro_3();

        // 1ère rencontre sauvage

        System.out.println("Attention, un pokémon sauvage attaque !");
        System.out.println("tu réagis en lançant ta PokéBall");
        texte.continuer();

        Attaque cran = new Attaque("Cran", 10);
        Attaque agitation = new Attaque("Agitation", 35);
        Pokemon rattata = new Pokemon("Rattata", 30,3500,90, cran, agitation, null, null);

        combat.pokemonSansDresseurs(pikachu, rattata);

        // Création du 1er ennemi

        texte.intro_4();

        Dresseur james = new Dresseur("James");
        Attaque crocDeMort = new Attaque("Croc-de-Mort", 80);
        Pokemon rattatac = new Pokemon("Rattatac", 130,13500,180, cran, agitation, crocDeMort, null);
        james.capture_sansCondition(rattatac);

        // 1er combat de dresseur
        combat.dresseurs(joueur, james);
        System.out.println();

        if (joueur.pokemons[0].getPv() <= 0) {
            System.out.println("Tu parviens néanmoins à fuir en courant, ton pokémon sous le bras.");
            System.out.printf("Malheureusement, ton %s est KO, n'a plus de PV !%n", joueur.pokemons[0].getNom());
            System.out.println("Il va donc falloir le soigner dans un Centre Pokémon.");
        }
        else {
            System.out.println("James s'enfuit sans demander son reste.");
            System.out.printf("Ton %s s'est bien battu, malheureusement il est mal en point (%d/%d pv)...%n", joueur.pokemons[0].getNom(), joueur.pokemons[0].getPv(), joueur.pokemons[0].getPvMax());
            System.out.println("Il va donc falloir le soigner dans un Centre Pokémon.");
        }

        texte.continuer();

        // Visite au centre Pokémon
        texte.intro_5();
        texte.centrePkmnIn();
        centrePokemon.soignerTousPkmn(joueur);
        texte.centrePkmnOut();

        // Fin de l'intro
        System.out.println();
        System.out.println("L'introduction est maintenant terminée, merci d'y avoir joué !");
        System.out.println("Si tu veux en voir plus, donne l'argent...");
    }

}
