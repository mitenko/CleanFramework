package com.example.mitenkodavid.cleanframework.component

import com.example.mitenkodavid.cleanframework.AppModule
import com.example.mitenkodavid.cleanframework.network.NetModule
import com.example.mitenkodavid.cleanframework.presenter.PresenterA
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, NetModule::class))
interface NetComponent {
    fun inject(presenter: PresenterA)
}