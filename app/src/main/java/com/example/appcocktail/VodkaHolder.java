package com.example.appcocktail;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VodkaHolder extends RecyclerView.ViewHolder {
    RecyclerView recyclerView;
    TextView ingredient_recipe, name_recipe, alcool_recipe,recipe;
    ImageView img_recipe;
    public VodkaHolder(@NonNull View itemView) {
        super(itemView);

        ingredient_recipe = itemView.findViewById(R.id.ingredient_recipe);
        name_recipe = itemView.findViewById(R.id.name_recipe);
        alcool_recipe = itemView.findViewById(R.id.alcool_recipe);
        recipe = itemView.findViewById(R.id.recipe);
        img_recipe = itemView.findViewById(R.id.img_recipe);
    }
}

