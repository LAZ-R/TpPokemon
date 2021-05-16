package fr.eni.quelPokemon.main;

import fr.eni.quelPokemon.bo.Attaque;
import fr.eni.quelPokemon.bo.Combat;
import fr.eni.quelPokemon.bo.Dresseur;
import fr.eni.quelPokemon.bo.Pokemon;

/** Classe Main
 *
 * @author laz_R
 * @version 1.0
 */
public class Main {


    public static void main(String[] args) {
        Combat combat = new Combat();
        Dresseur sacha = new Dresseur("Sacha");
        Dresseur ondine = new Dresseur("Ondine");

        Attaque statik = new Attaque("Statik", 20);
        Attaque paratonnerre = new Attaque("Paratonnerre", 75);

        Pokemon pikachu = new Pokemon("Pikachu",40,6000,120,statik,paratonnerre, null, null);

        sacha.capture(pikachu);

        //sacha.afficher();

        Attaque cran = new Attaque("Cran", 10);
        Attaque agitation = new Attaque("Agitation", 35);

        Pokemon rattata = new Pokemon("Rattata", 30,3500,90,cran,agitation, null, null);

        ondine.capture(rattata);

        //ondine.afficher();

        combat.pokemon(pikachu, rattata);

    }
}
