package com.example.mnu92.rickandmorty.Character;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.mnu92.rickandmorty.MainViewModel;
import com.example.mnu92.rickandmorty.R;

import java.util.List;


public class CharacterFragment extends Fragment {

    MainViewModel mainViewModel;
    final CharacterListAdapter characterListAdapter= new CharacterListAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rick_and_morty, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.showList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(characterListAdapter);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        getCharacters().observe(this, new Observer<List<Character>>() {
            @Override
            public void onChanged(@Nullable List<Character> characters) {
                characterListAdapter.setList(characters);
                characterListAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    public LiveData<List<Character>> getCharacters() {
        return MainViewModel.getCharacters();
    }

    public LiveData<Character> getCharacter(int id) {
        return MainViewModel.getCharacter(id);
    }


}

