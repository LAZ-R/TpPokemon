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
    public Pokemon[] pokemons;

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
        System.out.println(this.prenom);
    }
}
