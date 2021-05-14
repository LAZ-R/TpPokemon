package fr.eni.quelPokemon.bo;

import java.util.Random;

/** Classe qui représente un Pokémon.
 *
 * @author laz_R
 * @version 1.0
 */
public class Pokemon {

    // Attributs d'instances
    private String nom;
    private int taille;
    private int poids;
    private int pv;

    private Attaque attaque01;
    private Attaque attaque02;

    private Dresseur dresseur;

    // Attributs de classe

    // Méthodes

    /** Constructeur avec tous les paramètres, sauf Dresseur.
     *
     * @param nom String
     * @param taille int
     * @param poids int
     * @param pv int
     * @param attaque01 Attaque
     * @param attaque02 Attaque
     */
    public Pokemon(String nom, int taille, int poids, int pv, Attaque attaque01, Attaque attaque02) {
        this.nom = nom;
        this.taille = taille;
        this.poids = poids;
        this.pv = pv;
        this.attaque01 = attaque01;
        this.attaque02 = attaque02;
        this.dresseur = null;
    }

    /** Constructeur avec tous les paramètres.
     *
     * @param nom String
     * @param taille int
     * @param poids int
     * @param pv int
     * @param attaque01 Attaque
     * @param attaque02 Attaque
     * @param dresseur Dresseur
     */
    public Pokemon(String nom, int taille, int poids, int pv, Attaque attaque01, Attaque attaque02, Dresseur dresseur) {
        this.nom = nom;
        this.taille = taille;
        this.poids = poids;
        this.pv = pv;
        this.attaque01 = attaque01;
        this.attaque02 = attaque02;
        this.dresseur = dresseur;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTaille() {
        return this.taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getPoids() {
        return this.poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public int getPv() {
        return this.pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public Attaque getAttaque01() {
        return this.attaque01;
    }

    public void setAttaque01(Attaque attaque01) {
        this.attaque01 = attaque01;
    }

    public Attaque getAttaque02() {
        return this.attaque02;
    }

    public void setAttaque02(Attaque attaque02) {
        this.attaque02 = attaque02;
    }

    public Dresseur getDresseur() {
        return this.dresseur;
    }

    public void setDresseur(Dresseur dresseur) {
        this.dresseur = dresseur;
    }

    /** Méthode d'affichage des informations d'un Pokémon.
     */
    public void afficher() {
        System.out.printf("%s%n",this.nom.toUpperCase());
        System.out.printf("Taille : %.2fm%n", (double) this.taille / 100);
        System.out.printf("Poids : %.2fkg%n", (double) this.poids / 1000);
        System.out.printf("Points de vie : %dpv%n",this.pv);
        System.out.println("Attaque 01 :");
        this.attaque01.afficher();
        System.out.println("Attaque 02 :");
        this.attaque02.afficher();
        if (this.dresseur != null) {
            System.out.printf("Dresseur : %s%n",this.dresseur.getPrenom());
        }

    }

    public void attaque (Pokemon pokemonAttaque) {
        double rand = Math.random();
        if (rand > 0.1) {
            System.out.printf("%s lance %s%n", this.nom, this.attaque01.getNom());
            pokemonAttaque.setPv(pokemonAttaque.getPv() - this.attaque01.getPointsDeDegats());
            System.out.printf("%s perds %d points de vie !%n%n", pokemonAttaque.getNom(), this.attaque01.getPointsDeDegats());
        }
        else {
            System.out.printf("%s lance %s%n", this.nom, this.attaque02.getNom());
            pokemonAttaque.setPv(pokemonAttaque.getPv() - this.attaque02.getPointsDeDegats());
            System.out.printf("%s perds %d points de vie !%n%n", pokemonAttaque.getNom(), this.attaque02.getPointsDeDegats());
        }

    }
}
