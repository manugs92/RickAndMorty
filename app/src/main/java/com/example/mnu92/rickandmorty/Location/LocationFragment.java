package com.example.mnu92.rickandmorty.Location;

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


public class LocationFragment extends Fragment {

    MainViewModel mainViewModel;
    final LocationListAdapter locationListAdapter = new LocationListAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rick_and_morty, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.showList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(locationListAdapter);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        getLocations().observe(this, new Observer<List<Location>>() {
            @Override
            public void onChanged(@Nullable List<Location> locations) {
                locationListAdapter.setList(locations);
                locationListAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }


    public LiveData<List<Location>> getLocations() { return MainViewModel.getLocations(); }

    public LiveData<Location> getLocation(int id) {
        return MainViewModel.getLocation(id);
    }

}
