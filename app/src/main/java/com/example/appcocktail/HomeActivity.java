package com.example.appcocktail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        SearchView searchView = findViewById(R.id.searchView);
        searchView.setClickable(true);

        /**
         * Création d'un viewPager (Caroussel d'image)
         */


        ViewPager2 viewPager2;
        ArrayList<ItemCategory> viewItemCategory;

;
        /**
         * Tableaux contenant images et titre
         */

        viewPager2 = findViewById(R.id.viewPager);
        int [] images = {R.drawable.gin, R.drawable.rhum, R.drawable.whisky, R.drawable.vodka};
        String[] titles = {"Gin", "Rhum", "Wiskey", "Vodka"};




        viewItemCategory = new ArrayList<>();

        /**
         * Boucle pour faire correspondre image + titre
         */

        for(int i = 0; i < titles.length; i++) {


            ItemCategory itemCategory = new ItemCategory(images[i], titles[i]);
            viewItemCategory.add(itemCategory);

        }

        ItemAdapter itemAdapter = new ItemAdapter(viewItemCategory,this);



        /**
         * Permet de lier le modéle et la vue
         */
        viewPager2.setAdapter(itemAdapter);
        // A false définit que les enfants peuvent déborder
        viewPager2.setClipChildren(false);
        // Définit le nombre de page a conserver en mémoire
        viewPager2.setOffscreenPageLimit(3);
        // Aucun effet si utilisateur effectue un défillement hors des limites de la vue;
        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        Persistance persistance =new Persistance(this);
        persistance.open();
        Cursor c= persistance.select();

        Cocktail cocktailVar = new Cocktail(c.getString(2), c.getString(1),c.getString(5),c.getString(3),c.getString(4));

        Log.i("LOG", "valeur :" + cocktailVar);

    }
}