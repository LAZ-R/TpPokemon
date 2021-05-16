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
    private int pvMax;
    private int pv;

    private Dresseur dresseur;

    // Attributs de classe
    public Attaque[] set_attaques = new Attaque[4];
    // Méthodes

    /** Constructeur avec tous les paramètres, sauf Dresseur.
     *
     * @param nom String
     * @param taille int
     * @param poids int
     * @param pv int
     * @param attaque01 Attaque
     * @param attaque02 Attaque
     * @param attaque03 Attaque
     * @param attaque04 Attaque
     */
    public Pokemon(String nom, int taille, int poids, int pv, Attaque attaque01, Attaque attaque02, Attaque attaque03, Attaque attaque04) {
        this.nom = nom;
        this.taille = taille;
        this.poids = poids;
        this.pvMax = pv;
        this.pv = pv;
        this.set_attaques[0] = attaque01;
        this.set_attaques[1] = attaque02;
        this.set_attaques[2] = attaque03;
        this.set_attaques[3] = attaque04;

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
     * @param attaque03 Attaque
     * @param attaque04 Attaque
     * @param dresseur Dresseur
     */
    public Pokemon(String nom, int taille, int poids, int pv, Attaque attaque01, Attaque attaque02, Attaque attaque03, Attaque attaque04, Dresseur dresseur) {
        this.nom = nom;
        this.taille = taille;
        this.poids = poids;
        this.pvMax = pv;
        this.pv = pv;
        this.set_attaques[0] = attaque01;
        this.set_attaques[1] = attaque02;
        this.set_attaques[2] = attaque03;
        this.set_attaques[3] = attaque04;
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

    public Dresseur getDresseur() {
        return this.dresseur;
    }

    public void setDresseur(Dresseur dresseur) {
        this.dresseur = dresseur;
    }

    /** Méthode d'affichage du set d'attaque d'un pokémon
     */
    public void afficherSetAttaques() {
        for (int i = 0; i < this.set_attaques.length; i++) {
            if (this.set_attaques[i] != null) {
                System.out.printf("%d : ", i + 1);
                this.set_attaques[i].afficher();
            }
        }
    }

    /** Méthode d'affichage des informations d'un Pokémon.
     */
    public void afficher() {
        System.out.printf("%s%n",this.nom.toUpperCase());
        System.out.printf("Taille : %.2fm%n", (double) this.taille / 100);
        System.out.printf("Poids : %.2fkg%n", (double) this.poids / 1000);
        System.out.printf("Points de vie : %dpv%n",this.pv);
        System.out.println("Liste des attaques :");
        this.afficherSetAttaques();
        if (this.dresseur != null) {
            System.out.printf("Dresseur : %s%n",this.dresseur.getPrenom());
        }

    }

    public void attaque (Attaque attaque, Pokemon pokemonAttaque) {
        double rand = Math.random();
        if (rand > 0.1) {
            System.out.printf("%s lance %s%n", this.nom, attaque.getNom());
            pokemonAttaque.setPv(pokemonAttaque.getPv() - attaque.getPointsDeDegats());
            System.out.printf("%s perds %d points de vie !%n%n", pokemonAttaque.getNom(), attaque.getPointsDeDegats());
        }
        else {
            System.out.printf("%s lance %s%n", this.nom, attaque.getNom());
            System.out.printf("%s rate son attaque !%n%n",this.nom);
        }

    }
}
