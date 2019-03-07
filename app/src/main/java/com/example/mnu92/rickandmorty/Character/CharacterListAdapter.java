package com.example.mnu92.rickandmorty.Character;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mnu92.rickandmorty.GlideApp;
import com.example.mnu92.rickandmorty.R;

import java.util.ArrayList;
import java.util.List;
import retrofit2.http.Url;


public class CharacterListAdapter extends RecyclerView.Adapter<CharacterListAdapter.CharactersListViewHolder> {

    public List<Character> charactersList = new ArrayList<>();
    public final String NAME="Nombre: ";
    public final String DEBUT_EPISODE="Episodio de debut: ";
    public final String STATATUS="Estado: ";
    public final String GENDER="Género: ";
    public final String SPECIE="Espécie: ";
    public final String ID="ID";

    @NonNull
    @Override
    public CharactersListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemCharacter = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);
        return new CharactersListViewHolder(itemCharacter);
    }

    @Override
    public void onBindViewHolder(@NonNull CharactersListViewHolder holder, int position) {
        final Character character = charactersList.get(position);

        String[] urlEpisode = character.getDebutEpisode().get(0).split("/episode/");
        String debutEpisode = urlEpisode[1];

        holder.name.setText(NAME+character.name);
        holder.debut.setText(DEBUT_EPISODE+debutEpisode);
        holder.gender.setText(GENDER+character.gender);
        holder.status.setText(STATATUS+character.status);
        holder.specie.setText(SPECIE+character.species);
        GlideApp.with(holder.itemView.getContext()).load("https://rickandmortyapi.com/api/character/avatar/" + character.id+".jpeg").into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ShowCharacter.class);
                intent.putExtra(ID,character.id);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return  (charactersList != null ? charactersList.size() : 0);
    }

    public void setList(List<Character> list) {
        this.charactersList = list;
    }



    class CharactersListViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        TextView debut;
        TextView status;
        TextView specie;
        TextView gender;

        public CharactersListViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.characterImage);
            name = itemView.findViewById(R.id.name);
            debut = itemView.findViewById(R.id.debut);
            status = itemView.findViewById(R.id.status);
            specie = itemView.findViewById(R.id.specie);
            gender = itemView.findViewById(R.id.gender);
        }
    }
}
