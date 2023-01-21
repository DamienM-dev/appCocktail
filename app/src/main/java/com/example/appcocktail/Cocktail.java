package com.example.appcocktail;

public class Cocktail {

    private String nom;
    private String ingredient;
    private String recette;


    public Cocktail(String nom, String ingredient, String recette) {
        this.nom = nom;
        this.ingredient=ingredient;
        this.recette = recette;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getRecette() {
        return recette;
    }

    public void setRecette(String recette) {
        this.recette = recette;
    }

    @Override
    public String toString() {
        return "Cocktail{" +
                "nom='" + nom + '\'' +
                ", ingredient='" + ingredient + '\'' +
                ", recette='" + recette + '\'' +
                '}';
    }
}
