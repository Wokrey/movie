package com.example.movie

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import com.example.movie.di.modules

/**
 * Created by wokrey@gmail.com on 9/4/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class MovieApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MovieApplication)
            modules(modules = modules)
        }
    }
}