package com.example.mnu92.rickandmorty.Character;

import java.util.List;



public class Character {
    int id;
    String name;
    String status;
    String species;
    String gender;
    String image;
    List<String> episode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getDebutEpisode() {
        return episode;
    }

    public void setDebutEpisode(List<String> episodes) {
        this.episode = episodes;
    }
}
