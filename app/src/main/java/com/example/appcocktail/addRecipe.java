package com.example.appcocktail;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addRecipe extends AppCompatActivity {

    EditText nom, alcool,ingredient,image,recipe;
    Button add,sup;


    Persistance reqsql;
    ProgressDialog PD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        reqsql = new Persistance(this);


        nom = (EditText) findViewById(R.id.nom);
        alcool = (EditText) findViewById(R.id.alcool);
        ingredient = (EditText) findViewById(R.id.ingredient);
        image = (EditText) findViewById(R.id.image) ;
        recipe = (EditText) findViewById(R.id.recipe);
        add = (Button) findViewById(R.id.ajout);
        sup= (Button) findViewById(R.id.sup);

        BuildTable();

        sup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // lancement de la tache de suppression
                deleteDatas();

            }
        });

    }

    private void BuildTable() {
        // ouverture de bdd
        // selection des enregs
        reqsql.open();
        Cursor c = reqsql.select();
        // placement du cursor au debut
        c.moveToFirst();
        StringBuffer sb = new StringBuffer();
        // Parcours des resultats
        while (!c.isAfterLast()) {
            sb.append(c.getString(0) + "-" + c.getString(1) + "-"
                    + c.getString(2)+ "\n");
            c.moveToNext();
        }

    }

    // Tache pour insertion des datas
    private void insertDatas() {




        // recuperation des value nom prenom pour insertion

        String valnom = nom.getText().toString();
        String valalcool = alcool.getText().toString();
        String valingredient = ingredient.getText().toString();
        String valimage = image.getText().toString();
        String valrecipe = recipe.getText().toString();


        // insertion data
        reqsql.open();
        // instanciation dansla classe membre
        Cocktail ct = new Cocktail(valnom, valalcool,valingredient, valimage, valrecipe);
        // insertion en bdd
        reqsql.insertData(ct);
        reqsql.close();
        BuildTable();
        PD.dismiss();
    }


    // Tache pour supprimer des datas
    private void deleteDatas() {

        // ouverture bdd
        reqsql.open();
        // recuperation du dernier id ins�r�
        int id=reqsql.lastIdInsert();
        // suppression en bdd
        reqsql.deleteMembre(id);
        reqsql.close();
        BuildTable();
        PD.dismiss();

    }
}