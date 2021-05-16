package fr.eni.quelPokemon.bo;

public class Combat {

    public void pokemon(Pokemon pokemon1, Pokemon pokemon2) {
        System.out.printf("%s (%s)%n* VS *%n%s (%s)%n", pokemon1.getNom(), pokemon1.getDresseur().getPrenom(), pokemon2.getNom(), pokemon2.getDresseur().getPrenom());
        System.out.println();
        while (pokemon1.getPv() > 0 && pokemon2.getPv() > 0) {

            // TODO: demande l'attaque
            // x = input
            pokemon1.attaque(pokemon1.set_attaques[x], pokemon2);
            if (pokemon2.getPv() > 0) {

                // TODO : attaque au hasard pour le deuxieme pokémon
                pokemon2.attaque(pokemon1.set_attaques[y], pokemon1);
            }
        }

        if (pokemon1.getPv() <= 0) {
            System.out.printf("%s est K.O !%n", pokemon1.getNom());
            System.out.println();
        } else {
            System.out.printf("%s est K.O !%n", pokemon2.getNom());
            System.out.println();
        }
    }
}
