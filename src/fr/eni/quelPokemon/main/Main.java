package fr.eni.quelPokemon.main;

import fr.eni.quelPokemon.bo.Attaque;
import fr.eni.quelPokemon.bo.Combat;
import fr.eni.quelPokemon.bo.Dresseur;
import fr.eni.quelPokemon.bo.Pokemon;

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


    public static void main(String[] args) {

        texte.intro();

        String nom_joueur = global_scanner.nextLine();
        Dresseur joueur = new Dresseur(nom_joueur);

        Attaque statik = new Attaque("Statik", 20);
        Attaque paratonnerre = new Attaque("Paratonnerre", 75);

        Pokemon pikachu = new Pokemon("Pikachu",40,6000,120,statik,paratonnerre, null, null);

        joueur.capture_sansCondition(pikachu);

        System.out.println("Félicitation, voici ton premier Pokémon !");
        System.out.println();
        pikachu.afficher();
        System.out.println();
        System.out.println("appuye sur ENTRÉE pour continuer");
        global_scanner.nextLine();
        Dresseur ondine = new Dresseur("Ondine");


        // NORMAL

        Attaque cran = new Attaque("Cran", 10);
        Attaque agitation = new Attaque("Agitation", 35);


        // ELECTRIK



        //sacha.afficher();



        Pokemon rattata = new Pokemon("Rattata", 30,3500,90,cran,agitation, null, null);

        ondine.capture_sansCondition(rattata);

        //ondine.afficher();

        combat.pokemon(pikachu, rattata);

    }
}
