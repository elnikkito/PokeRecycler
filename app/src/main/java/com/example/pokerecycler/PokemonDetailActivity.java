package com.example.pokerecycler;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class PokemonDetailActivity extends AppCompatActivity {

    private ImageView pokemonImage;
    private TextView pokemonName;
    private TextView pokemonDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        pokemonImage = findViewById(R.id.pokemonDetailImage);
        pokemonName = findViewById(R.id.pokemonDetailName);
        pokemonDescription = findViewById(R.id.pokemonDetailDescription);

        String name = getIntent().getStringExtra("pokemon_name");
        String imageUrl = getIntent().getStringExtra("pokemon_image");
        String description = getIntent().getStringExtra("pokemon_description");

        pokemonName.setText(name);
        pokemonDescription.setText(description);
        Glide.with(this).load(imageUrl).into(pokemonImage);
    }
}
