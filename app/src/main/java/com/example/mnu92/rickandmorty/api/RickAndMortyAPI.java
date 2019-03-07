package com.example.mnu92.rickandmorty.api;

import com.example.mnu92.rickandmorty.Character.Character;
import com.example.mnu92.rickandmorty.Character.CharactersList;
import com.example.mnu92.rickandmorty.Episode.Episode;
import com.example.mnu92.rickandmorty.Episode.EpisodeList;
import com.example.mnu92.rickandmorty.Location.Location;
import com.example.mnu92.rickandmorty.Location.LocationsList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface RickAndMortyAPI {

    @GET("api/character")
    Call<CharactersList> getCharacters();

    @GET("api/character/{id}")
    Call<Character> getCharacter(@Path("id") int id);

    @GET("api/episode")
    Call<EpisodeList> getEpisodes();

    @GET("api/episode/{id}")
    Call<Episode> getEpisode(@Path("id") int id);


    @GET("api/location")
    Call<LocationsList> getLocations();

   @GET("api/location/{id}")
   Call<Location> getLocation(@Path("id") int id);

}
