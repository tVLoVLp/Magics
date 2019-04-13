package com.example.magics;

import com.google.firebase.firestore.Exclude;

public class Note {
    private String title;
    private String description;
    private int priority;
    private String mKey;



    public Note() {
        //empty constructor needed
    }

    public Note(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    @Exclude
    public String getmKey() {
        return mKey;
    }
    @Exclude
    public void setmKey(String key) {
        mKey = key;
    }

}