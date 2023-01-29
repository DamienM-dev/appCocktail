package com.example.appcocktail;

import android.content.ClipData;
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
import java.util.List;

public class CocktailAdapter extends RecyclerView.Adapter<VodkaHolder>{

    Context context;
    List<Cocktail> ct;

    public CocktailAdapter(Context context, List<Cocktail> ct) {
        this.context = context;
        this.ct = ct;
    }

    @NonNull
    @Override
    public VodkaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VodkaHolder(LayoutInflater.from(context).inflate(R.layout.item_vodka,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VodkaHolder holder, int position) {

        holder.ingredient_recipe.setText(ct.get(position).getIngredient());
        holder.name_recipe.setText(ct.get(position).getNom());
        holder.alcool_recipe.setText(ct.get(position).getAlcool());

        holder.recipe.setText(ct.get(position).getRecipe());
    }

    @Override
    public int getItemCount() {
        return ct.size();
    }
}
