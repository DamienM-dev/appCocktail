package com.example.appcocktail;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RecipeCocktailDataBase extends SQLiteOpenHelper {

    public static final String TABLE_COCKTAIL = "cocktail";
    public static final String COCKTAIL_ID = "_id";
    public static final String COCKTAIL_NAME= "nom";
    public static final String COCKTAIL_RECIPE = "recette";

    private static final String DATABASE_NAME = "cocktails.db";
    private static final int DATABASE_VERSION = 1;

    String createTableSql = "CREATE TABLE " +
            TABLE_COCKTAIL + " (" +
            COCKTAIL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COCKTAIL_NAME + " TEXT NOT NULL, " +
            COCKTAIL_RECIPE + " TEXT NOT NULL" +
            ");";

    public RecipeCocktailDataBase (Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        sqLiteDatabase.execSQL(createTableSql);


    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_COCKTAIL);

        onCreate(sqLiteDatabase);

    }
}
