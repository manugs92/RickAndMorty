package com.example.mnu92.rickandmorty.Character;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mnu92.rickandmorty.GlideApp;
import com.example.mnu92.rickandmorty.MainViewModel;
import com.example.mnu92.rickandmorty.R;

public class ShowCharacter extends AppCompatActivity {

    public final String ID="ID";
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_character);
        Intent intent = getIntent();
        int id = intent.getIntExtra(ID,0);

        final ImageView imageView = findViewById(R.id.characterImage);
        final TextView TVName = findViewById(R.id.name);
        final String STVName = (String) TVName.getText();
        final TextView TVDebut = findViewById(R.id.debut);
        final String STVDebut = (String) TVDebut.getText();
        final TextView TVStatus = findViewById(R.id.status);
        final String STVStatus = (String) TVStatus.getText();
        final TextView TVSpecie = findViewById(R.id.specie);
        final String STVSpecie = (String) TVSpecie.getText();
        final TextView TVGender = findViewById(R.id.gender);
        final String STVGender = (String) TVGender.getText();

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getCharacter(id).observe(this, new Observer<Character>() {
            @Override
            public void onChanged(@Nullable Character character) {
                GlideApp.with(ShowCharacter.this)
                        .load("https://rickandmortyapi.com/api/character/avatar/" + character.id+".jpeg")
                        .into(imageView);
                TVName.setText(STVName+" "+character.getName());
                String[] urlEpisode = character.getDebutEpisode().get(0).split("/episode/");
                String debutEpisode = urlEpisode[1];
                TVDebut.setText(STVDebut+" "+debutEpisode);
                TVStatus.setText(STVStatus+" "+character.getStatus());
                TVSpecie.setText(STVSpecie+" "+character.getSpecies());
                TVGender.setText(STVGender+" "+character.getGender());
            }
        });

    }
}
