package com.example.movie.di

import com.example.movie.base.api.ApiService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by wokrey@gmail.com on 9/4/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */


const val BASE_URL = "https://api.themoviedb.org/3/"
const val API_KEY = "api_key"
const val API_KEY_VALUE = "02da584cad2ae31b564d940582770598"

val appModule = module {
    single {
        OkHttpClient.Builder().addInterceptor {
            val urlPostfix = it.request()
                .url()
                .newBuilder()
                .addQueryParameter(API_KEY, API_KEY_VALUE)
                .build()

            val request = it.request()
                .newBuilder()
                .url(urlPostfix)
                .addHeader("Accept", "Application/JSON")
                .build()

            return@addInterceptor it.proceed(request)
        }
            .build()
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