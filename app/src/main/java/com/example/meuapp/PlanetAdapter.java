package com.example.meuapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {
    private List<Planet> planetList;

    public PlanetAdapter(List<Planet> planetList) {
        this.planetList = planetList;
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.planet_item, parent, false);
        return new PlanetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder holder, int position) {
        Planet planet = planetList.get(position);
        holder.planetName.setText(planet.getName());
        holder.planetImage.setImageResource(planet.getImageResource());
    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }

    static class PlanetViewHolder extends RecyclerView.ViewHolder {
        ImageView planetImage;
        TextView planetName;

        public PlanetViewHolder(@NonNull View itemView) {
            super(itemView);
            planetImage = itemView.findViewById(R.id.planetImage);
            planetName = itemView.findViewById(R.id.planetName);
        }
    }
}
