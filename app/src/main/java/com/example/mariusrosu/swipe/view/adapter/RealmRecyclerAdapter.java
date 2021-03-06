package com.example.mariusrosu.swipe.view.adapter;

import android.support.v7.widget.RecyclerView;

import io.realm.RealmBaseAdapter;
import io.realm.RealmObject;

/**
 * Created by Marius-Andrei Rosu on 02/09/16.
 */

public abstract class RealmRecyclerAdapter<T extends RealmObject, D extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<D> {
    private RealmBaseAdapter<T> mRealmBaseAdapter;

    public T getItem(int position) {
        return mRealmBaseAdapter.getItem(position);
    }

    public RealmBaseAdapter<T> getRealmAdapter() {
        return mRealmBaseAdapter;
    }

    public void setRealmAdapter(RealmBaseAdapter<T> realmAdapter) {
        mRealmBaseAdapter = realmAdapter;
    }
}
