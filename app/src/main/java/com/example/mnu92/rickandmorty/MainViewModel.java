package com.example.mnu92.rickandmorty;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.mnu92.rickandmorty.Character.Character;
import com.example.mnu92.rickandmorty.Episode.Episode;
import com.example.mnu92.rickandmorty.Location.Location;

import java.util.List;

public class MainViewModel extends AndroidViewModel{


    private static RickAndMortyDbRepository rickAndMortyDbRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        rickAndMortyDbRepository = new RickAndMortyDbRepository();
    }

    public static LiveData<List<Character>> getCharacters(){
        return rickAndMortyDbRepository.getCharacters();
    }

    public static LiveData<Character> getCharacter(int id){
        return rickAndMortyDbRepository.getCharacter(id);
    }

    public static LiveData<List<Location>> getLocations() {
        return rickAndMortyDbRepository.getLocations();
    }

    public static LiveData<Location> getLocation(int id) {
        return rickAndMortyDbRepository.getLocation(id);
    }

    public static LiveData<List<Episode>> getEpisodes() {
        return rickAndMortyDbRepository.getEpisodes();
    }

    public static LiveData<Episode> getEpisode(int id){
        return rickAndMortyDbRepository.getEpisode(id);
    }
}
