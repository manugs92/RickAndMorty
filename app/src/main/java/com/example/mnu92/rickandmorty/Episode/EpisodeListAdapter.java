package com.example.mnu92.rickandmorty.Episode;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.mnu92.rickandmorty.R;
import java.util.ArrayList;
import java.util.List;


public class EpisodeListAdapter extends RecyclerView.Adapter<EpisodeListAdapter.EpisodeListViewHolder> {
    public List<Episode> episodeList = new ArrayList<>();
    public final String NAME="Nombre: ";
    public final String AIR_DATE="Fecha de emisión: ";
    public final String EPISODE="Episodio: ";
    public final String ID="ID";

    @NonNull
    @Override
    public EpisodeListAdapter.EpisodeListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemEpisode = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_episode, parent, false);
        return new EpisodeListViewHolder(itemEpisode);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeListAdapter.EpisodeListViewHolder holder, int position) {
        final Episode episode = episodeList.get(position);

        holder.name.setText(NAME+episode.name);
        holder.airDate.setText(AIR_DATE+episode.air_date);
        holder.episode.setText(EPISODE+episode.episode);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ShowEpisode.class);
                intent.putExtra(ID,episode.id);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return  (episodeList != null ? episodeList.size() : 0);
    }

    public void setList(List<Episode> list) {
        this.episodeList = list;
    }



    class EpisodeListViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView airDate;
        TextView episode;

        public EpisodeListViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.episode_name);
            airDate = itemView.findViewById(R.id.air_date);
            episode = itemView.findViewById(R.id.n_episode);
        }
    }
}
