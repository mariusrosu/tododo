package com.example.mariusrosu.swipe.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Marius-Andrei Rosu on 02/09/16.
 */

public class Task extends RealmObject {
    @PrimaryKey
    private long mId;
    private String mTitle;
    private String mDescription;

    public Task() {
    }

    public Task(String mTitle, String mDescription) {
        this.mId = System.currentTimeMillis();
        this.mTitle = mTitle;
        this.mDescription = mDescription;
    }

    public long getId() {
        return mId;
    }

    public void setId(long mId) {
        this.mId = mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}
