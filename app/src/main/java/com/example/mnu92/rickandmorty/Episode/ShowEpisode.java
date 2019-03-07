package com.example.mnu92.rickandmorty.Episode;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import com.example.mnu92.rickandmorty.MainViewModel;
import com.example.mnu92.rickandmorty.R;



public class ShowEpisode extends AppCompatActivity {

    public final String ID="ID";
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_episode);
        Intent intent = getIntent();
        int id = intent.getIntExtra(ID,0);

        final TextView tvEpisodeName = findViewById(R.id.episode_name);
        final String stvEpisodeName = tvEpisodeName.getText().toString();
        final TextView tvAirDate =  findViewById(R.id.air_date);
        final String stvAirDate = tvAirDate.getText().toString();
        final TextView tvEpisode = findViewById(R.id.n_episode);
        final String stvEpisode = tvEpisode.getText().toString();

        mainViewModel = ViewModelProviders.of(ShowEpisode.this).get(MainViewModel.class);
        mainViewModel.getEpisode(id).observe(this, new Observer<Episode>() {
            @Override
            public void onChanged(@Nullable Episode episode) {
                tvEpisodeName.setText(stvEpisodeName+" "+episode.name);
                tvAirDate.setText(stvAirDate+" "+episode.air_date);
                tvEpisode.setText(stvEpisode+" "+episode.episode);
            }
        });
    }
}
