package fr.eni.quelPokemon.bo;

/** Classe qui représente une Attaque.
 *
 * @author laz_R
 * @version 1.0
 */
public class Attaque {

    // Attributs d'instances
    private String nom;
    private int pointsDeDegats;

    // Attributs de classe


    // Méthodes

    /** Constructeur avec tous les paramètres.
     *
     * @param nom String
     * @param pointsDeDegats int
     */
    public Attaque(String nom, int pointsDeDegats) {
        this.nom = nom;
        this.pointsDeDegats = pointsDeDegats;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPointsDeDegats() {
        return this.pointsDeDegats;
    }

    public void setPointsDeDegats(int pointsDeDegats) {
        this.pointsDeDegats = pointsDeDegats;
    }

    /** Méthode d'affichage des informations d'une attaque.
     */
    public void afficher() {
        System.out.printf("%s (%d points de dégâts)%n", this.nom, this.pointsDeDegats);
    }
}
