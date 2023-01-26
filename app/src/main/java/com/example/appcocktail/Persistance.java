package com.example.appcocktail;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;

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


      String nom =ct.getNom();
      String alcool = ct.getAlcool();
      String image = ct.getImage();
      String ingredient = ct.getIngredient();
      String recipe = ct.getRecipe();


        ContentValues values = new ContentValues();


        values.put(RecipeCocktailDataBase.COCKTAIL_ALCOOL, "rhum");
        values.put(RecipeCocktailDataBase.COCKTAIL_ALCOOL, "Rum Runner");
        values.put(RecipeCocktailDataBase.COCKTAIL_ALCOOL,
                "5 cl rhum ambré jamaicain, " +
                        "11 cl de jus d'ananas, " +
                        "2 cl jus de citron pressé" +
                        "3 gouttes d'Angousta bitters" +
                        "5 glaçons");
        values.put(RecipeCocktailDataBase.COCKTAIL_ALCOOL, "> Mettez les glaçons et les ingrédients dans la partie inférieur du shakers" +
                "> Ajustez la partie supérieur du shaker et secouez vivevement pendant 10 secondes" +
                "> filtrez au-dessus du verre highball à l'aide d'une passoire à glaçon. Servez aussitôt");


        values.put(RecipeCocktailDataBase.COCKTAIL_IMAGE, "https://zupimages.net/up/23/03/l01s.jpg");
        database.insert(RecipeCocktailDataBase.TABLE_COCKTAIL, null, values);

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
        String selectQuery = "SELECT  * FROM " + RecipeCocktailDataBase.TABLE_COCKTAIL ;
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