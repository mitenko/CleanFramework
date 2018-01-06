package com.example.mitenkodavid.cleanframework.network

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Dagger2 Module that provides all the Net-related services
 */
@Module
class ApiModule {
    /**
     * Provides agent service
     * @param retrofit
     * @return
     */
    @Singleton
    @Provides
    internal fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create<ApiService>(ApiService::class.java)
    }
}