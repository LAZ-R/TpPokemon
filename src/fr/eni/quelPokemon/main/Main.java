package fr.eni.quelPokemon.main;

import fr.eni.quelPokemon.bo.Attaque;
import fr.eni.quelPokemon.bo.Dresseur;
import fr.eni.quelPokemon.bo.Pokemon;

/** Classe Main
 *
 * @author laz_R
 * @version 1.0
 */
public class Main {

    public static void combat(Pokemon pokemon1, Pokemon pokemon2) {
        System.out.printf("%s (%s)%n* VS *%n%s (%s)%n", pokemon1.getNom(), pokemon1.getDresseur().getPrenom(), pokemon2.getNom(), pokemon2.getDresseur().getPrenom());
        System.out.println();
        while (pokemon1.getPv() > 0 && pokemon2.getPv() > 0) {
            pokemon1.attaque(pokemon2);
            if (pokemon2.getPv() > 0) {
                pokemon2.attaque(pokemon1);
            }
        }

        if (pokemon1.getPv() <= 0) {
            System.out.printf("%s est K.O !%n", pokemon1.getNom());
            System.out.println();
            System.out.printf("%s a perdu !%n", pokemon1.getDresseur().getPrenom());
        } else {
            System.out.printf("%s est K.O !%n", pokemon2.getNom());
            System.out.println();
            System.out.printf("%s a perdu !%n", pokemon2.getDresseur().getPrenom());
        }
    }

    public static void main(String[] args) {
        Dresseur sacha = new Dresseur("Sacha");
        Dresseur ondine = new Dresseur("Ondine");

        Attaque statik = new Attaque("Statik", 20);
        Attaque paratonnerre = new Attaque("Paratonnerre", 75);

        Pokemon pikachu = new Pokemon("Pikachu",40,6000,120,statik,paratonnerre);

        sacha.capture(pikachu);

        //sacha.afficher();

        Attaque cran = new Attaque("Cran", 10);
        Attaque agitation = new Attaque("Agitation", 35);

        Pokemon rattata = new Pokemon("Rattata", 30,3500,90,cran,agitation);

        ondine.capture(rattata);

        //ondine.afficher();

        combat(pikachu, rattata);

    }
}
