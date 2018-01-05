package com.example.mitenkodavid.cleanframework

import android.support.multidex.MultiDexApplication
import com.example.mitenkodavid.cleanframework.component.AppComponent
import com.facebook.stetho.Stetho
import timber.log.Timber

class MainApplication: MultiDexApplication() {
  /*  val appComponent: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }*/

    override fun onCreate() {
        super.onCreate()
      //  appComponent.inject(this)

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
            Timber.plant(Timber.DebugTree())
        }
    }
}