package com.example.appcocktail;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.util.Log;

import java.io.ByteArrayOutputStream;

/*
 * Classe permettant d'�x�cuter les requetes sql sur la table membre
 */
public class Persistance {

    private RecipeCocktailDataBase dbhelper;
    private Context moncontext;
    private SQLiteDatabase database;

    // constructeur
    public Persistance(Context c) {
        moncontext = c;
    }

    // ouverture de la bdd
    public Persistance open() throws SQLException {
        dbhelper = new RecipeCocktailDataBase(moncontext);
        database = dbhelper.getWritableDatabase();
        return this;

    }

    // fermeture de la bdd
    public void close() {
        dbhelper.close();
    }

    // requete insertion
    public void insertData(Cocktail ct) {

    }

    // requete de suppression
    public void deleteMembre(int id) {

        database.delete(RecipeCocktailDataBase.TABLE_COCKTAIL, RecipeCocktailDataBase.COCKTAIL_ID
                + " = " + id, null);

    }

    // recuperation du dernier id ins�r�
    public int lastIdInsert() {

        final String MY_QUERY = "SELECT MAX(_id) FROM "
                + RecipeCocktailDataBase.TABLE_COCKTAIL;
        Cursor cur = database.rawQuery(MY_QUERY, null);
        cur.moveToFirst();
        int ID = cur.getInt(0);

        return ID;

    }

    // requete de selection

    public Cursor select() {

        String query = "SELECT * FROM cocktail WHERE alcool = 'vodka'";
        Cursor c = database.rawQuery(query, null);

        if (c != null) {
            c.moveToFirst();
        }
        //c.close();
        assert c != null;
       return c;
    }



}