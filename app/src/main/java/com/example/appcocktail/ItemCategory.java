package com.example.appcocktail;

import android.content.Intent;

public class ItemCategory {

    int imageID;
    String title;


    public ItemCategory(int imageID, String title) {
        this.imageID = imageID;
        this.title = title;

    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
