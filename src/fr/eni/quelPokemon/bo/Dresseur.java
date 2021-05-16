package fr.eni.quelPokemon.bo;

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
        for (int i = 0; i < pokemons.length; i++) {
            System.out.printf("Pokémon %d :%n", i+1);
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

    public void capture_sansCondition(Pokemon pokemonCapture) {
        for (int i = 0; i < this.pokemons.length; i++) {
            if (pokemons[i] == null) {
                pokemons[i] = pokemonCapture;
                pokemons[i].setDresseur(this);
                break;
            }
        }
    }

    public int combienDePokemon() {
        int nbPoke = 0;
        for (int i = 0; i < this.pokemons.length; i++) {
            if (pokemons[i] == null) {
                nbPoke +=1;
            }
        }
        return nbPoke;
    }
}
