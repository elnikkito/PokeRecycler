package com.example.pokerecycler;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private com.example.pokerecycler.PokemonAdapter pokemonAdapter;
    private com.example.pokerecycler.PokemonViewModel pokemonViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        pokemonAdapter = new com.example.pokerecycler.PokemonAdapter(this, null);
        recyclerView.setAdapter(pokemonAdapter);


        pokemonViewModel = new ViewModelProvider(this).get(com.example.pokerecycler.PokemonViewModel.class);


        pokemonViewModel.getPokemonList().observe(this, new Observer<List<com.example.pokerecycler.Pokemon>>() {
            @Override
            public void onChanged(List<com.example.pokerecycler.Pokemon> pokemonList) {
                pokemonAdapter = new com.example.pokerecycler.PokemonAdapter(MainActivity.this, pokemonList);
                recyclerView.setAdapter(pokemonAdapter);
            }
        });


        pokemonViewModel.fetchPokemonData();
    }
}
