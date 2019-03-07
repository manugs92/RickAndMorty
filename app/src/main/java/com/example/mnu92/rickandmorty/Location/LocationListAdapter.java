package com.example.mnu92.rickandmorty.Location;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.mnu92.rickandmorty.Episode.ShowEpisode;
import com.example.mnu92.rickandmorty.R;

import java.util.ArrayList;
import java.util.List;

public class LocationListAdapter  extends RecyclerView.Adapter<LocationListAdapter.LocationListViewHolder> {

    public List<Location> locationList = new ArrayList<>();
    public final String NAME="Nombre: ";
    public final String TYPE="Tipo: ";
    public final String DIMENSION="Dimensión: ";
    public final String ID="ID";

    @NonNull
    @Override
    public LocationListAdapter.LocationListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLocation = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location, parent, false);
        return new LocationListAdapter.LocationListViewHolder(itemLocation);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationListAdapter.LocationListViewHolder holder, int position) {
        final Location location = locationList.get(position);

        holder.name.setText(NAME+location.name);
        holder.locationType.setText(TYPE+location.type);
        holder.dimension.setText(DIMENSION+location.dimension);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ShowLocation.class);
                intent.putExtra(ID,location.id);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return  (locationList != null ? locationList.size() : 0);
    }

    public void setList(List<Location> list) {
        this.locationList= list;
    }



    class LocationListViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView locationType;
        TextView dimension;

        public LocationListViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.location_name);
            locationType = itemView.findViewById(R.id.location_type);
            dimension = itemView.findViewById(R.id.location_dimension);
        }
    }
}
