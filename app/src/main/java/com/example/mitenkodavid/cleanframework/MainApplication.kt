package com.example.mitenkodavid.cleanframework

import android.support.multidex.MultiDexApplication
import com.facebook.stetho.Stetho
import timber.log.Timber

/**
 * Created by Real Estate Webmasters on 12/29/2017.
 * Copyright © Real Estate Webmasters. All rights reserved.
 */
class MainApplication: MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
            Timber.plant(Timber.DebugTree())
        }
    }
}