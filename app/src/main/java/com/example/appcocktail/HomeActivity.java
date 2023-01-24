package com.example.appcocktail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
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

        /**
         * Création d'une liste déroulante
         */

        Spinner spinner = findViewById(R.id.spinner);

        String[] items = {"Vodka", "Rhum", "Gin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setClickable(true);

        /**
         * Création d'un viewPager (Caroussel d'image)
         */

        ViewPager2 viewPager2;
        ArrayList<ItemCategory> viewItemCategory;

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

        for(int i = 0; i < images.length; i++) {

            ItemCategory itemCategory = new ItemCategory(images[i], titles[i]);
            viewItemCategory.add(itemCategory);

        }



        ItemAdapter itemAdapter = new ItemAdapter(viewItemCategory);

        /**
         * Permet de lier le modéle et la vue
         */
        viewPager2.setAdapter(itemAdapter);
        
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);




    }
}