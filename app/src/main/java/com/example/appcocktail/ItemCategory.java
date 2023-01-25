package com.example.appcocktail;

import android.content.Intent;

public class ItemCategory {

    int imageID;
    String title;
    Intent intent;

    public ItemCategory(int imageID, String title, Intent intent) {
        this.imageID = imageID;
        this.title = title;
        this.intent = intent;
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

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }
}
