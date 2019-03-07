package com.example.mnu92.rickandmorty.Location;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mnu92.rickandmorty.Episode.Episode;
import com.example.mnu92.rickandmorty.Episode.ShowEpisode;
import com.example.mnu92.rickandmorty.MainViewModel;
import com.example.mnu92.rickandmorty.R;

public class ShowLocation extends AppCompatActivity {

    public final String ID="ID";
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_location);
        Intent intent = getIntent();
        int id = intent.getIntExtra(ID,0);

        final TextView tvLocationName = findViewById(R.id.location_name);
        final String stvLocationdeName = tvLocationName.getText().toString();
        final TextView tvLocationType =  findViewById(R.id.location_type);
        final String stvLocationType = tvLocationType.getText().toString();
        final TextView tvDimension = findViewById(R.id.location_dimension);
        final String stvDimension = tvDimension.getText().toString();

        mainViewModel = ViewModelProviders.of(ShowLocation.this).get(MainViewModel.class);
        mainViewModel.getLocation(id).observe(this, new Observer<Location>() {
            @Override
            public void onChanged(@Nullable Location location) {
                tvLocationName.setText(stvLocationdeName+" "+location.name);
                tvLocationType.setText(stvLocationType+" "+location.type);
                tvDimension.setText(stvDimension+" "+location.dimension);
            }
        });
    }
}
