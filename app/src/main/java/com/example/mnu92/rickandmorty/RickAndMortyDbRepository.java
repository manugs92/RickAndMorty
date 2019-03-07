package com.example.mnu92.rickandmorty;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.mnu92.rickandmorty.Character.Character;
import com.example.mnu92.rickandmorty.Character.CharactersList;
import com.example.mnu92.rickandmorty.Episode.Episode;
import com.example.mnu92.rickandmorty.Episode.EpisodeList;
import com.example.mnu92.rickandmorty.Location.Location;
import com.example.mnu92.rickandmorty.Location.LocationsList;
import com.example.mnu92.rickandmorty.api.RickAndMortyAPI;
import com.example.mnu92.rickandmorty.api.RickAndMortyDbModule;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RickAndMortyDbRepository {
    RickAndMortyAPI rickAndMortyAPI;

    public RickAndMortyDbRepository() {
        rickAndMortyAPI = RickAndMortyDbModule.getAPI();
    }

    public LiveData<List<Character>> getCharacters() {
        final MutableLiveData<List<Character>> characterList = new MutableLiveData<>();

        rickAndMortyAPI.getCharacters().enqueue(new Callback<CharactersList>() {
            @Override
            public void onResponse(Call<CharactersList> call, Response<CharactersList> response) {
                characterList.setValue(response.body().results);
            }

            @Override
            public void onFailure(Call<CharactersList> call, Throwable t) {
            }
        });

        return characterList;
    }

    public LiveData<Character> getCharacter(int id) {

        final MutableLiveData<Character> character = new MutableLiveData<>();
        rickAndMortyAPI.getCharacter(id).enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                character.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
            }
        });

        return character;
    }


    public LiveData<List<Location>> getLocations() {
        final MutableLiveData<List<Location>> locationList = new MutableLiveData<>();

        rickAndMortyAPI.getLocations().enqueue(new Callback<LocationsList>() {
            @Override
            public void onResponse(Call<LocationsList> call, Response<LocationsList> response) {
                locationList.setValue(response.body().results);
            }

            @Override
            public void onFailure(Call<LocationsList> call, Throwable t) {

            }
        });

        return locationList;
    }

    public LiveData<Location> getLocation(int id) {
        final MutableLiveData<Location> location = new MutableLiveData<>();

        rickAndMortyAPI.getLocation(id).enqueue(new Callback<Location>() {
            @Override
            public void onResponse(Call<Location> call, Response<Location> response) {
                location.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Location> call, Throwable t) {

            }
        });

        return location;

    }

    public LiveData<List<Episode>> getEpisodes() {
        final MutableLiveData<List<Episode>> episodeList = new MutableLiveData<>();

        rickAndMortyAPI.getEpisodes().enqueue(new Callback<EpisodeList>() {
            @Override
            public void onResponse(Call<EpisodeList> call, Response<EpisodeList> response) {
                episodeList.setValue(response.body().results);
            }

            @Override
            public void onFailure(Call<EpisodeList> call, Throwable t) {

            }
        });

        return episodeList;
    }

    public LiveData<Episode> getEpisode(int id) {
        final MutableLiveData<Episode> episode = new MutableLiveData<>();

        rickAndMortyAPI.getEpisode(id).enqueue(new Callback<Episode>() {
            @Override
            public void onResponse(Call<Episode> call, Response<Episode> response) {
                episode.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Episode> call, Throwable t) {

            }
        });

        return episode;
    }


}
