package com.example.pokerecycler;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class PokemonViewModel extends AndroidViewModel {

    private MutableLiveData<List<Pokemon>> pokemonList;
    private PokemonRepository repository;

    public PokemonViewModel(Application application) {
        super(application);
        repository = new PokemonRepository();
        pokemonList = new MutableLiveData<>();
    }

    public LiveData<List<Pokemon>> getPokemonList() {
        return pokemonList;
    }

    public void fetchPokemonData() {
        pokemonList.setValue(repository.getPokemonList());
    }
}
