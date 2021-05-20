package fr.eni.quelPokemon.texte;

import java.util.Scanner;

/** Classe qui contient les textes relatifs à l'histoire,
 *  chaque dialogue étant sous forme de méthode.
 *
 * @author laz_R
 * @version 1.0
 */
public class HistoireTextes {

    static Scanner global_scanner = new Scanner(System.in);

    /** Méthode pour demander au joueur de continuer l'execution
     *
     */
    public void continuer() {

        System.out.println();
        System.out.println("(Appuie sur ENTRÉE pour continuer)");
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

        System.out.println("Tu sors du laboratoire du Professeur Chen en remerciant son assistant et en admirant ta PokéBall.");
        System.out.println();
        System.out.println("En te baladant autour du labo, tu entends un bruit dans les hautes herbes environnantes.");
        continuer();
    }

    public void intro_4() {

        System.out.println("Après cette rencontre un peu mouvementée, tu décides d'aller acheter des bonbons.");
        System.out.println("Tu prends donc la route de la boulangerie.");
        continuer();
        System.out.println("Au détour d'une allée, tu rencontres un homme avec une casquette un peu étrange.");
        System.out.println("Il te demande l'heure, mais tu vois bien qu'il essaye de voler ta PokéBall !!!");
        System.out.println();
        System.out.println("Se sentant démasqué, il te défie dans un Combat de Dresseurs !");
        continuer();
    }

    public void intro_5() {
        System.out.println("Tu te diriges donc vers le Centre Pokémon le plus proche.");
        System.out.println("Tu arrives devant le bâtiment.");
        continuer();
    }

    public void centrePkmnIn() {
        System.out.println("♫ ♪ DING ♪ ♫");
        System.out.println("\"Bonjour, et bienvenue dans notre centre Pokémon !\"");
        System.out.println("\"Confiez-nous vos Pokémons.\"");
        continuer();
    }

    public void centrePkmnOut() {
        System.out.println("\"Voilà, vos Pokémons sont en pleine forme !\"");
        System.out.println(":)");
        System.out.println("\"À bientôt !\"");
        continuer();
    }

}
