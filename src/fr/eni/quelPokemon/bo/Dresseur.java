package fr.eni.quelPokemon.bo;

import java.util.Random;

/** Classe qui représente un Dresseur Pokémon.
 *
 * @author laz_R
 * @version 1.0
 */
public class Dresseur {

    // Attributs d'instances
    private String prenom;


    //Attributs de classe
    public Pokemon[] pokemons = new Pokemon[6];

    // Méthodes

    /** Constructeur avec tous les paramètres.
     *
     * @param prenom String
     */
    public Dresseur(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Pokemon[] getPokemons() {
        return this.pokemons;
    }

    public void setPokemons(Pokemon[] pokemons) {
        this.pokemons = pokemons;
    }

    /** Méthode d'affichage des informations du dresseur.
     */
    public void afficher() {
        System.out.println("******* Dresseur *******");
        System.out.printf("%s%n", this.prenom);
        System.out.println();
        System.out.println("******** Équipe ********");
        System.out.println();
        for (int i = 0; i < pokemons.length; i++) {
            System.out.printf("Pokémon %d :%n", i+1);
            System.out.println();
            if (pokemons[i] != null) {
                pokemons[i].afficher();
                System.out.println();
            }
            else {
                System.out.println("(vide)");
                System.out.println();
            }
        }
        System.out.println();
    }

    /** Méthode qui ajoute un pokémon au tableau de pokémon de ce dresseur ("capture")
     *  sans condition.
     *
     * @param pokemonCapture Pokemon
     */
    public void capture_sansCondition(Pokemon pokemonCapture) {
        for (int i = 0; i < this.pokemons.length; i++) {
            if (pokemons[i] == null) {
                pokemons[i] = pokemonCapture;
                pokemons[i].setDresseur(this);
                break;
            }
        }
    }

    /** Méthode qui régit la façon dont un dresseur essaye de capturer un pokémon
     *
     * @param pokemonCapture Pokemon
     */
    public void captureNormale(Pokemon pokemonCapture) {

        // Si le pokémon a capturer est bien sauvage (son dresseur est "null")
        if (pokemonCapture.getDresseur() == null) {

            double random_number = Math.random();

            // Si le pokémon a capturer a plus de 50% de sa vie
            if ((double)pokemonCapture.getPv() / (double)pokemonCapture.getPvMax() > 0.50) {

                // On a que 20% de chance de le capturer
                if (random_number > 0.80) {
                    for (int i = 0; i < this.pokemons.length; i++) {
                        if (pokemons[i] == null) {
                            pokemons[i] = pokemonCapture;
                            pokemons[i].setDresseur(this);
                            System.out.printf("%s a bien été capturé !%n%n", pokemonCapture.getNom());
                            break;
                        }
                    }
                }
                else {
                    System.out.println("La tentative de capture a échoué !");
                }
            }
            // Si le pokémon a capturer a plus de 25% de sa vie
            else if ((double)pokemonCapture.getPv() / (double)pokemonCapture.getPvMax() > 0.25) {

                // On passe à 50% de chance de le capturer
                if (random_number > 0.50) {
                    for (int i = 0; i < this.pokemons.length; i++) {
                        if (pokemons[i] == null) {
                            pokemons[i] = pokemonCapture;
                            pokemons[i].setDresseur(this);
                            System.out.printf("%s a bien été capturé !%n%n", pokemonCapture.getNom());
                            break;
                        }
                    }
                }
                else {
                    System.out.println("La tentative de capture a échoué !");
                }
            }
            // Si le pokémon a capturer a moins de 25% de sa vie
            else {

                // On passe à 80% de chance de le capturer
                if (random_number > 0.20) {
                    for (int i = 0; i < this.pokemons.length; i++) {
                        if (pokemons[i] == null) {
                            pokemons[i] = pokemonCapture;
                            pokemons[i].setDresseur(this);
                            System.out.printf("%s a bien été capturé !%n%n", pokemonCapture.getNom());
                            break;
                        }
                    }
                }
                else {
                    System.out.println("La tentative de capture a échoué !");
                }
            }

        }
        // Si le pokémon n'est pas sauvage (son dresseur n'est pas "null")
        else {
            System.out.println("Il est impossible de capturer un pokémon appartenant déjà à un dresseur !");
        }


    }

    /** Méthode qui renvoie le nombre de pokémon dans l'équipe de pokémon de ce dresseur.
     *
     * @return int
     */
    public int combienDePokemon() {
        int nbPoke = 0;
        // Pour chaque case du tableau de Pokémons
        for (int i = 0; i < this.pokemons.length; i++) {
            // Si la case n'est pas nulle
            if (pokemons[i] == null) {
                // on incrémente le nombre de Pokémons dans l'équipe
                nbPoke +=1;
            }
        }
        return nbPoke;
    }
}