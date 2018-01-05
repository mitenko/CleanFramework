package com.example.mitenkodavid.cleanframework

import android.app.Application
import dagger.Module
import javax.inject.Singleton
import dagger.Provides

/**
 * Dagger2 Module that provides the Application
 */
@Module
class AppModule(val app: Application) {
    @Provides
    @Singleton
    fun providesApp() = app
}