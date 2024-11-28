package com.example.pokerecycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private Context context;
    private List<Pokemon> pokemonList;

    public PokemonAdapter(Context context, List<Pokemon> pokemonList) {
        this.context = context;
        this.pokemonList = pokemonList;
    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pokemon, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder holder, int position) {
        final Pokemon pokemon = pokemonList.get(position);
        holder.pokemonName.setText(pokemon.getName());
        Glide.with(context)
                .load(pokemon.getImageUrl())
                .into(holder.pokemonImage);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, PokemonDetailActivity.class);
            intent.putExtra("pokemon_name", pokemon.getName());
            intent.putExtra("pokemon_image", pokemon.getImageUrl());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return pokemonList != null ? pokemonList.size() : 0;
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {

        TextView pokemonName;
        ImageView pokemonImage;

        public PokemonViewHolder(View itemView) {
            super(itemView);
            pokemonName = itemView.findViewById(R.id.pokemonName);
            pokemonImage = itemView.findViewById(R.id.pokemonImage);
        }
    }
}

