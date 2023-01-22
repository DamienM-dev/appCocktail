package com.example.appcocktail;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.util.Log;

import java.io.ByteArrayOutputStream;

public class RecipeCocktailDataBase extends SQLiteOpenHelper {

    public static final String TABLE_COCKTAIL = "cocktail";
    public static final String COCKTAIL_ID = "_id";
    public static final String COCKTAIL_ALCOOL = "alcool";
    public static final String COCKTAIL_NAME= "nom";
    public static final String COCKTAIL_IMAGE = "image";
    public static final String COCKTAIL_INGREDIENT = "ingredient";
    public static final String COCKTAIL_RECIPE = "recette";

    private static final String DATABASE_NAME = "cocktails.db";
    private static final int DATABASE_VERSION = 1;

    String createTableSql = "CREATE TABLE " +
            TABLE_COCKTAIL + " (" +
            COCKTAIL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COCKTAIL_NAME + " TEXT NOT NULL, " +
            COCKTAIL_ALCOOL + "TEXT NOT NULL," +
            COCKTAIL_IMAGE + " BLOB NOT NULL, " +
            COCKTAIL_INGREDIENT + "TEXT NOT NULL, " +
            COCKTAIL_RECIPE + " TEXT NOT NULL" +
            ");";



    public RecipeCocktailDataBase (Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        sqLiteDatabase.execSQL(createTableSql);
        Log.i("DATABASE", "ma bdd a été crée !");



    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_COCKTAIL);

        onCreate(sqLiteDatabase);

    }

    public void addRecipe(String name, String alcool, String ingredient, String recette, Bitmap image) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        
        values.put(COCKTAIL_ALCOOL, "rhum");
        values.put(COCKTAIL_NAME, "Rum Runner");
        values.put(COCKTAIL_RECIPE,
                        "5 cl rhum ambré jamaicain, " +
                        "11 cl de jus d'ananas, " +
                        "2 cl jus de citron pressé" +
                                "3 gouttes d'Angousta bitters" +
                                "5 glaçons");
        values.put("> recette", "Mettez les glaçons et les ingrédients dans la partie inférieur du shakers" +
                "> Ajustez la partie supérieur du shaker et secouez vivevement pendant 10 secondes" +
                "> filtrez au-dessus du verre highball à l'aide d'une passoire à glaçon. Servez aussitôt");

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.PNG, 0, stream);
        byte[] imageData = stream.toByteArray();
        values.put(COCKTAIL_IMAGE, "https://zupimages.net/up/23/03/l01s.jpg");

        db.insert(TABLE_COCKTAIL, null, values);
        db.close();


    }
}
