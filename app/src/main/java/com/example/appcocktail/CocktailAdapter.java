package com.example.appcocktail;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class CocktailAdapter extends RecyclerView.Adapter<CocktailAdapter.ViewHolder>{

    private Context context;
    private Intent[] intents;

    public CocktailAdapter(ArrayList<Cocktail> viewPager2ArrayList) {

        this.viewPager2ArrayList = viewPager2ArrayList;
        this.context = context;
        this.intents = intents;
    }

    ArrayList<Cocktail> viewPager2ArrayList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_vodka_page,parent,false);



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Cocktail cocktail = viewPager2ArrayList.get(position);

        //Le holder stock les éléments afin d'éviter de devoir les recréer à chaque fois
        holder.titleView.setText(cocktail.nom);
        holder.titleView.setText(cocktail.alcool);
        holder.titleView.setText(cocktail.ingredient);
        holder.titleView.setText(cocktail.recipe);
        holder.titleView.setText(cocktail.image);


    }

    @Override
    public int getItemCount() {

        return viewPager2ArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            titleView = itemView.findViewById(R.id.name_recipe);
            titleView = itemView.findViewById(R.id.alcool_recipe);
            titleView = itemView.findViewById(R.id.ingredient_recipe);
            titleView = itemView.findViewById(R.id.img_recipe);
            titleView = itemView.findViewById(R.id.recipe);
        }
    }
}


