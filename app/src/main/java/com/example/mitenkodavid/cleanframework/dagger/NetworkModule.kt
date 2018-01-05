package com.example.mitenkodavid.cleanframework.dagger

import android.app.Application
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    /**
     * Provides OkHttp cache
     * @param application
     * @return
     */
    @Provides
    @Singleton
    internal fun providesOkHttpCache(application: Application): Cache {
        // @TODO Use cache in interceptor
        val cacheSize = 10 * 1024 * 1024 // 10 MiB
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    internal fun providesOkHttpClient(cache: Cache): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.readTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
        builder.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)

        // Network debugging
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        builder.addNetworkInterceptor(StethoInterceptor())
        builder.addInterceptor(logging)

        builder.cache(cache)
        return builder.build()
    }

    companion object {
        /**
         * Server specified Keep-Alive specs
         */
        private val CONNECTION_TIMEOUT = (60 * 1000).toLong()
    }
}