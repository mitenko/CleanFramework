package com.example.mitenkodavid.cleanframework

import android.support.multidex.MultiDexApplication
import com.facebook.stetho.Stetho
import timber.log.Timber

class MainApplication: MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
            Timber.plant(Timber.DebugTree())
        }
    }
}