package com.example.appcocktail;

public class Cocktail {

    String alcool, nom, image, ingredient, recipe;

    public Cocktail(String alcool, String nom, String image, String ingredient, String recipe) {

        this.alcool = alcool;
        this.nom = nom;
        this.image = image;
        this.ingredient = ingredient;
        this.recipe = recipe;
    }



    public String getAlcool() {
        return alcool;
    }

    public void setAlcool(String alcool) {
        this.alcool = alcool;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "Cocktail{" +

                ", alcool='" + alcool + '\'' +
                ", nom='" + nom + '\'' +
                ", image='" + image + '\'' +
                ", ingredient='" + ingredient + '\'' +
                ", recipe='" + recipe + '\'' +
                '}';
    }
}
