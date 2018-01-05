package com.example.mitenkodavid.cleanframework.component

import com.example.mitenkodavid.cleanframework.AppModule
import com.example.mitenkodavid.cleanframework.MainApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(application: MainApplication)
}
