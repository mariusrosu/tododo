package com.example.mariusrosu.swipe.view.adapter;

import android.content.Context;

import com.example.mariusrosu.swipe.model.Task;

import io.realm.RealmResults;

/**
 * Created by Marius-Andrei Rosu on 02/09/16.
 */

public class RealmToDoAdapter extends RealmModelAdapter<Task> {

    public RealmToDoAdapter(Context context, RealmResults<Task> realmResults) {
        super(context, realmResults);
    }
}
