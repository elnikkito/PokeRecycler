package com.example.pokerecycler;

import java.util.ArrayList;
import java.util.List;

public class PokemonRepository {

    public List<Pokemon> getPokemonList() {
        List<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(new Pokemon("Pikachu", R.drawable.descarga));
        pokemonList.add(new Pokemon("Bulbasaur", R.drawable.descarga));
        pokemonList.add(new Pokemon("Charmander", R.drawable.descarga));
        pokemonList.add(new Pokemon("Squirtle", R.drawable.descarga));
        return pokemonList;
    }
}
