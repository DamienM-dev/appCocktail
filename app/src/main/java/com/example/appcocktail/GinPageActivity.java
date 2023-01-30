package com.example.appcocktail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.google.android.gms.common.api.Response;


import java.util.ArrayList;
import java.util.List;

public class GinPageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gin_page);


        RecyclerView recyclerView = findViewById(R.id.gin_recycler_view);
        List<Cocktail> ct = new ArrayList<Cocktail>();
        Persistance persistance =new Persistance(this);
        persistance.open();



        Cursor c= persistance.selectGin();
        Cocktail cocktailVar = new Cocktail(c.getString(2), c.getString(1),c.getString(5),c.getString(3),c.getString(4));
        ct.add(cocktailVar);
        persistance.close();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CocktailAdapter(getApplicationContext(),ct));
    }
    }
