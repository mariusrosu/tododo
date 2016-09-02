package com.example.mariusrosu.swipe;

import android.app.Application;

import com.example.mariusrosu.swipe.model.realm.RealmUtils;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Marius-Andrei Rosu on 02/09/16.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name(RealmUtils.FILE_NAME)
                .schemaVersion(RealmUtils.SCHEMA_VERSION)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
