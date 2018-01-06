package com.example.mitenkodavid.cleanframework.component

import com.example.mitenkodavid.cleanframework.AppModule
import com.example.mitenkodavid.cleanframework.MainApplication
import com.example.mitenkodavid.cleanframework.network.ApiModule
import com.example.mitenkodavid.cleanframework.network.NetModule
import com.example.mitenkodavid.cleanframework.presenter.PresenterA
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Real Estate Webmasters on 1/5/2018.
 * Copyright © Real Estate Webmasters. All rights reserved.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, ApiModule::class, NetModule::class))
interface AppComponent {
    fun inject(presenter: PresenterA)
}