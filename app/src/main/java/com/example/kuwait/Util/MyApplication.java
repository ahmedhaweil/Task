package com.example.kuwait.Util;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(getApplicationContext());

        RealmConfiguration config =
                new RealmConfiguration.Builder()
                        .name("news")
                        .schemaVersion(1)
                        .deleteRealmIfMigrationNeeded()
                        .build();

        Realm.setDefaultConfiguration(config);
    }
}