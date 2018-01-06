package com.example.mitenkodavid.cleanframework.network

import android.app.Application
import com.example.mitenkodavid.cleanframework.MainApplication
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Dagger2 Module that provides all the Net-related services
 */
@Module
class NetModule {
    companion object {
        /**
         * The base URL for Retrofit
         */
        val BASE_URL = "https://www.wikipedia.org/w/"

        /**
         * Server specified Keep-Alive specs
         */
        private val CONNECTION_TIMEOUT = (60 * 1000).toLong()
    }

    /**
     * Provides OkHttp cache
     * @param application
     * @return
     */
    @Provides
    @Singleton
    internal fun providesOkHttpCache(app: Application): Cache {
        // @TODO Use cache in interceptor
        val cacheSize = 10 * 1024 * 1024 // 10 MiB
        return Cache(app.cacheDir, cacheSize.toLong())
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

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

    /**
     * Provides the Retrofit Connection
     */
    @Singleton
    @Provides
    internal fun providesRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        var baseUrl = BASE_URL

        // Build
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }
}