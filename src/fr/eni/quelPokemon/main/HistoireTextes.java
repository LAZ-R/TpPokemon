package fr.eni.quelPokemon.main;

public class HistoireTextes {

    public void intro_1() {

        System.out.println();
        System.out.println();
        System.out.println("***** Pokémon version Étoile rouge *******");
        System.out.println();
        System.out.println();
        System.out.println("Tout d'abord, quel est ton nom ?");
    }

    public void intro_2(String nomJoueur) {

        System.out.printf("Bonjour %s, et bienvenue dans le monde merveilleux de Pokémon !%n",nomJoueur);
        System.out.println();
        System.out.println("Le professeur Chen est parti, mais il a laissé une Pokéball pour toi !");
    }

}
