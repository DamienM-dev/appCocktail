package com.example.appcocktail;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class VodkaPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vodka_page);

        RecyclerView recyclerView;

        // Liaison de la vue de recyclage à partir de l'ID de vue dans le fichier de layout

        recyclerView = findViewById(R.id.vodka_recycler_view);

        Persistance persistance =new Persistance(this);


        Cursor c= persistance.select();
      Cocktail cocktailVar = new Cocktail(c.getString(2), c.getString(1),c.getString(5),c.getString(3),c.getString(4));

        Log.i("LOG", "valeur :" + cocktailVar);



    }
}

