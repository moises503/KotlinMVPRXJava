package com.moises.kotlinmvp.core

import android.app.Activity
import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class CoreModule {
    private lateinit var activity : Activity
    private lateinit var fragment : Fragment

    private val baseUrl = "https://api.themoviedb.org/3/movie/"
    private val apiKey = "a9175dc7137dddc6cb7a8a75e5ddc32b"

    constructor(activity: Activity){
        this.activity = activity
    }

    constructor(fragment: Fragment){
        this.fragment = fragment
    }

    @Provides
    @Singleton
    fun providesActivity() : Activity {
        return this.activity
    }

    @Provides
    @Singleton
    fun providesFragment() : Fragment {
        return this.fragment
    }


    @Provides
    @Singleton
    fun providesHttpClient() : OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient().newBuilder().addInterceptor(interceptor).addInterceptor {
            var request = it.request()
            val url = request.url().newBuilder().addQueryParameter("api_key", apiKey).build()
            request = request.newBuilder().url(url).build()
            it.proceed(request)
        }.build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(httpClient : OkHttpClient) : Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

}