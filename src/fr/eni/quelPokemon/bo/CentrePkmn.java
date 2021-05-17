package fr.eni.quelPokemon.bo;

public class CentrePkmn {

    public void soignerTousPkmn(Dresseur dresseur) {

        for (int i = 0; i < dresseur.pokemons.length; i++) {
            if (dresseur.pokemons[i] != null) {
                dresseur.pokemons[i].setPv(dresseur.pokemons[i].getPvMax());
            }
        }

    }

}
