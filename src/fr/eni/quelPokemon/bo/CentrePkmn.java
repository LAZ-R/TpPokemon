package fr.eni.quelPokemon.bo;

/** Classe qui représente un Centre Pokémon.
 *
 * @author laz_R
 * @version 1.0
 */
public class CentrePkmn {

    /** Méthode qui permets de soigner tous les pokémons d'un dresseur.
     *
     * @param dresseur Dresseur
     */
    public void soignerTousPkmn(Dresseur dresseur) {

        for (int i = 0; i < dresseur.pokemons.length; i++) {
            if (dresseur.pokemons[i] != null) {
                dresseur.pokemons[i].setPv(dresseur.pokemons[i].getPvMax());
            }
        }

    }

}
