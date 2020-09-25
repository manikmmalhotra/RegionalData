package com.example.regionaldata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.regionaldata.Model.Model;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryHolder> {

    Context context;
    List<Model> response;

    public CountryAdapter(Context context, List<Model> response) {
        this.context = context;
        this.response = response;
    }

    @NonNull
    @Override
    public CountryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.contry_item, parent, false);
        return new CountryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryHolder holder, int position) {

        holder.country.setText(response.get(position).getName().toString());
        holder.capital.setText(response.get(position).getCapital().toString());
        holder.region.setText(response.get(position).getRegion().toString());
        holder.subregion.setText(response.get(position).getSubregion().toString());
        holder.border.setText(response.get(position).getBorders().toString());
        holder.population.setText(response.get(position).getPopulation().toString());
        Picasso.get()
                .load(response.get(position).getFlag().toString())
                .into(holder.Flag);

    }

    @Override
    public int getItemCount() {
       return response.size();
    }

    class CountryHolder extends RecyclerView.ViewHolder {

        TextView country,region,subregion,population,capital,border;
        ImageView Flag;
        LinearLayout relativeLayout;

        public CountryHolder(View itemView) {
            super(itemView);

            country = itemView.findViewById(R.id.country);
            region = itemView.findViewById(R.id.region);
            subregion = itemView.findViewById(R.id.subregion);
            population = itemView.findViewById(R.id.population);
            capital = itemView.findViewById(R.id.capital);
            border = itemView.findViewById(R.id.Borders);
            Flag = itemView.findViewById(R.id.flag);
            relativeLayout = itemView.findViewById(R.id.Expandable);

        }

    }
}