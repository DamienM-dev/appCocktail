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

    private static final String DATABASE_NAME = "cocktail.db";
    private static final int DATABASE_VERSION = 1;



    public RecipeCocktailDataBase (Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createTableSql = "CREATE TABLE " +
                TABLE_COCKTAIL + " (" +
                COCKTAIL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COCKTAIL_NAME + " TEXT NOT NULL, " +
                COCKTAIL_ALCOOL + "TEXT NOT NULL," +
                COCKTAIL_IMAGE + " BLOB NOT NULL, " +
                COCKTAIL_INGREDIENT + "TEXT NOT NULL, " +
                COCKTAIL_RECIPE + " TEXT NOT NULL" +
                ");";



        sqLiteDatabase.execSQL(createTableSql);
        Log.i("DATABASE", "ma bdd a été crée !");



    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_COCKTAIL);

        onCreate(sqLiteDatabase);

    }


}
