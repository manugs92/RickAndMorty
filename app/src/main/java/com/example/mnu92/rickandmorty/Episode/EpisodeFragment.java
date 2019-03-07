package com.example.mnu92.rickandmorty.Episode;

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

public class EpisodeFragment extends Fragment {

    MainViewModel mainViewModel;
    final EpisodeListAdapter EpisodeListAdapter= new EpisodeListAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rick_and_morty, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.showList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(EpisodeListAdapter);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        getEpisodes().observe(this, new Observer<List<Episode>>() {
            @Override
            public void onChanged(@Nullable List<Episode> episodes) {
                EpisodeListAdapter.setList(episodes);
                EpisodeListAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    public LiveData<List<Episode>> getEpisodes() {
        return MainViewModel.getEpisodes();
    }

    public LiveData<Episode> getEpisode(int id) {
        return MainViewModel.getEpisode(id);
    }
}
