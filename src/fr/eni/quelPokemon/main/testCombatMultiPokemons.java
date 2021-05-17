package fr.eni.quelPokemon.main;

import fr.eni.quelPokemon.bo.Attaque;
import fr.eni.quelPokemon.bo.Combat;
import fr.eni.quelPokemon.bo.Dresseur;
import fr.eni.quelPokemon.bo.Pokemon;

public class testCombatMultiPokemons {

    static Combat combat = new Combat();

    public static void main(String[] args) {
        Attaque attaque1 = new Attaque("attaque1", 25);
        Attaque attaque2 = new Attaque("attaque2", 50);
        Attaque attaque3 = new Attaque("attaque3", 100);

        Pokemon carapuce = new Pokemon("Carapuce", 150, 5000, 150, attaque1, attaque2, attaque3, null);
        Pokemon salameche = new Pokemon("Salamèche", 150, 5000, 150, attaque1, attaque2, attaque3, null);
        Pokemon bulbizarre = new Pokemon("Bulbizarre", 150, 5000, 150, attaque1, attaque2, attaque3, null);
        Pokemon pikachu = new Pokemon("Pikachu", 150, 5000, 150, attaque1, attaque2, attaque3, null);

        Dresseur joueur1 = new Dresseur("Joueur 1");
        joueur1.capture_sansCondition(carapuce);
        joueur1.capture_sansCondition(salameche);
        Dresseur joueur2 = new Dresseur("Joueur 2");
        joueur2.capture_sansCondition(bulbizarre);
        joueur2.capture_sansCondition(pikachu);

        combat.dresseurs(joueur1, joueur2);
    }

}
