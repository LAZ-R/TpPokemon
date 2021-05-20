package fr.eni.quelPokemon.main;

import fr.eni.quelPokemon.bo.Attaque;
import fr.eni.quelPokemon.bo.Dresseur;
import fr.eni.quelPokemon.bo.Pokemon;

public class TestCaptureNormale {

    public static void main(String[] args) {
        Dresseur sacha = new Dresseur("Sacha");
        Attaque charge = new Attaque("Charge", 10);
        Pokemon pikachu = new Pokemon("Pikachu", 100, 1000, 100, charge, null, null, null);
        sacha.capture_sansCondition(pikachu);


        Attaque sans_effet = new Attaque("SansEffet", 0);
        Pokemon rattata = new Pokemon("Rattata", 100, 1000, 100, sans_effet, null, null, null);
        rattata.setPv(20);

        sacha.captureNormale(rattata);

       // sacha.afficher();
    }
}
