package com.example.movie.di

import android.preference.PreferenceManager
import com.example.movie.base.api.ApiService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by wokrey@gmail.com on 9/4/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */


const val BASE_URL = "https://api.themoviedb.org/3"

val appModule = module {
    single {
        OkHttpClient.Builder().addInterceptor {
            val request = it.request()
                .newBuilder()
                .addHeader("Accept", "Application/JSON")
                .build()

            return@addInterceptor it.proceed(request)
        }
            .build()
    }

    single {
        PreferenceManager.getDefaultSharedPreferences(androidApplication().applicationContext)
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(ApiService::class.java)
    }
}