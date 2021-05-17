package fr.eni.quelPokemon.main;

import java.util.Scanner;

public class HistoireTextes {

    static Scanner global_scanner = new Scanner(System.in);

    public void continuer() {

        System.out.println();
        System.out.println("(appuye sur ENTRÉE pour continuer)");
        global_scanner.nextLine();

    }

    public void intro_1() {

        System.out.println();
        System.out.println();
        System.out.println("***** Pokémon version Étoile Bleue *******");
        System.out.println();
        System.out.println();
        System.out.println("Tout d'abord, quel est ton nom ?");
    }

    public void intro_2(String nomJoueur) {

        System.out.printf("Bonjour %s, et bienvenue dans le monde merveilleux de Pokémon !%n",nomJoueur);
        System.out.println();
        System.out.println("Tu es désormais en âge d'avoir ton premier Pokémon !");
        System.out.println("Tu te diriges donc vers le labo du Professeur Chen.");
        continuer();
        System.out.println("Son assistant te reçoit :");
        System.out.println("\"Le Professeur Chen est sorti, mais il a laissé une PokéBall pour toi !\"");
        continuer();
    }

    public void intro_3() {

        System.out.println("Tu sors du laboratoire du Professeur Chen en remerciant son assistant et en admirant ta PokéBall");
        System.out.println();
        System.out.println("En te baladant autour du labo, tu entends un bruit dans des hautes herbes.");
        continuer();
    }

    public void intro_4() {

        System.out.println("Tu rencontres un homme avec une casquette un peu étrange au détour d'une allée");
        System.out.println("Il te demande l'heure, mais te le vois bien essayer de voler ta PokéBall !");
        System.out.println();
        System.out.println("Se sentant démasqué, il te défie dans un Combat de Dresseurs !");
        continuer();
    }

    public void intro_5() {
        System.out.println("Tu te diriges donc vers le Centre Pokémon le plus proche");
        System.out.println("Tu arrives devant le bâtiment, essouflé et inquiet.");
        continuer();
    }

    public void centrePkmnIn() {
        System.out.println("*DING*");
        System.out.println("Bonjour et bienvenu dans notre centre Pokémon !");
        System.out.println("Confiez-nous vos Pokémons");
        continuer();
    }

    public void centrePkmnOut() {
        System.out.println("Voilà, vos Pokémons sont en pleine forme !");
        System.out.println(":)");
        System.out.println("À bientôt !");
        continuer();
    }

}
