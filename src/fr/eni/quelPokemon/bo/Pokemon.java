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
        // Pour l'affichage, les pv ne seront jamais négatifs
        if (this.pv < 0) {
            this.pv = 0;
        }
    }

    public int getPvMax() {
        return pvMax;
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
        // Pour chaque case du tableau d'attaque
        for (int i = 0; i < this.set_attaques.length; i++) {
            //Si la case n'est pas vide
            if (this.set_attaques[i] != null) {
                // On affiche l'attaque
                System.out.printf("  %d/ ", i + 1);
                this.set_attaques[i].afficher();
            }
            else {
                // Sinon on affiche qu'elle est vide
                System.out.printf("  %d/ (vide)%n", i + 1);
            }
        }
    }

    /** Méthode d'affichage des informations d'un Pokémon.
     */
    public void afficher() {
        System.out.printf("%s%n",this.nom.toUpperCase());
        System.out.printf("Taille : %.2fm%n", (double) this.taille / 100);
        System.out.printf("Poids : %.2fkg%n", (double) this.poids / 1000);
        System.out.printf("Points de vie : [%d/%dpv]%n",this.pv, this.pvMax);
        System.out.println("Liste des attaques :");
        this.afficherSetAttaques();
        if (this.dresseur != null) {
            System.out.printf("Dresseur : %s%n",this.dresseur.getPrenom());
        }

    }

    /** Méthode qui régit la façon dont un pokémon lance une attaque.
     *  Lancement aléatoire de coups critiques et d'échecs.
     *
     * @param attaque Attaque
     * @param pokemonAdverse Pokemon
     */
    public void attaque (Attaque attaque, Pokemon pokemonAdverse) {

        /* Un chiffre aléatoire compris entre 0 et 1 est choisi à chaque lancement d'attaque pour gérer
         * les probabilités qu'a un pokémon de rater une attaque, ou au contraire de faire un coup critique.
         */
        double rand = Math.random();

        // La probabillité d'échec est differente selon le pourcentage de vie restante du pokémon qui lance l'attaque.

        // On regarde donc d'abord si la vie du pokémon est supérieure ou égale à 35% de son total de pv.
        if (this.pv / this.pvMax >= 0.35) {

            // Si le chiffre aléatoire est supérieur à 0.1 (90% des cas) le pokémon lance son attaque sans souci
            if (rand > 0.1) {
                System.out.printf("%s lance %s%n", this.nom, attaque.getNom());

                // dans les 15% les plus hauts, on lance un coup critique
                if (rand > 0.85) {
                    // On va donc enlever aux pv du pokémon adverse les points de dégats de l'attaque (x 1.5 parce que coup critique)
                    pokemonAdverse.setPv(pokemonAdverse.getPv() - (int)(attaque.getPointsDeDegats() * 1.5));
                    System.out.println("Coup critique !");
                    System.out.printf("%s perds %d points de vie ! [%d/%dpv]%n%n", pokemonAdverse.getNom(), (int)(attaque.getPointsDeDegats() * 1.5), pokemonAdverse.getPv(), pokemonAdverse.getPvMax());
                }

                // Sinon on lance une attaque normale
                else {

                    // On va donc enlever aux pv du pokémon adverse les points de dégats de l'attaque
                    pokemonAdverse.setPv(pokemonAdverse.getPv() - attaque.getPointsDeDegats());
                    System.out.printf("%s perds %d points de vie ! [%d/%dpv]%n%n", pokemonAdverse.getNom(), attaque.getPointsDeDegats(), pokemonAdverse.getPv(), pokemonAdverse.getPvMax());
                }

            }

            // Si le chiffre aléatoire est inférieur à 0.1 (10% des cas), le pokémon rate son attaque
            else {
                System.out.printf("%s lance %s%n", this.nom, attaque.getNom());
                System.out.printf("%s rate son attaque !%n%n",this.nom);
            }
        }

        // Si la vie du pokémon est inférieure à 35% de son total de pv.
        else {

            // Si le chiffre aléatoire est supérieur à 0.2 (80% des cas) le pokémon lance son attaque sans souci
            if (rand > 0.2) {
                System.out.printf("%s lance %s%n", this.nom, attaque.getNom());

                // dans les 15% les plus hauts, on lance un coup critique
                if (rand > 0.85) {

                    // On va donc enlever aux pv du pokémon adverse les points de dégats de l'attaque (x 1.5 parce que coup critique)
                    pokemonAdverse.setPv(pokemonAdverse.getPv() - (int)(attaque.getPointsDeDegats() * 1.5));
                    System.out.println("Coup critique !");
                    System.out.printf("%s perds %d points de vie ! [%d/%dpv]%n%n", pokemonAdverse.getNom(), (int)(attaque.getPointsDeDegats() * 1.5), pokemonAdverse.getPv(), pokemonAdverse.getPvMax());
                }

                // Sinon on lance une attaque normale
                else {
                    // On va donc enlever aux pv du pokémon adverse les points de dégats de l'attaque
                    pokemonAdverse.setPv(pokemonAdverse.getPv() - attaque.getPointsDeDegats());
                    System.out.printf("%s perds %d points de vie ! [%d/%dpv]%n%n", pokemonAdverse.getNom(), attaque.getPointsDeDegats(), pokemonAdverse.getPv(), pokemonAdverse.getPvMax());
                }
            }

            // Si le chiffre aléatoire est inférieur à 0.2 (20% des cas), le pokémon rate son attaque
            else {
                System.out.printf("%s lance %s%n", this.nom, attaque.getNom());
                System.out.printf("%s rate son attaque !%n%n",this.nom);
            }
        }
    }
}
