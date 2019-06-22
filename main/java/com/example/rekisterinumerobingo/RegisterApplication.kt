package com.example.rekisterinumerobingo

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class RegisterApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val realmConfig = RealmConfiguration.Builder()
            .name("register.realm")
            .schemaVersion(1)
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(realmConfig)
    }
}