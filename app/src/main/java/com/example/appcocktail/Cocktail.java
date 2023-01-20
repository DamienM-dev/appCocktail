package com.example.appcocktail;

public class Cocktail {

    private String nom;
    private String recette;


    public Cocktail(String nom, String recette) {
        this.nom = nom;
        this.recette = recette;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
                ", recette='" + recette + '\'' +
                '}';
    }
}
