package com.example.movie.di

import com.example.movie.main.films.data.DefaultUpcomingRepository
import com.example.movie.main.films.data.UpcomingRepository
import com.example.movie.main.films.domain.UpcomingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by wokrey@gmail.com on 9/6/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */

val upcomingModule = module {

    viewModel {
        UpcomingViewModel(
            repository = get()
        )
    }

    factory<UpcomingRepository> {
        DefaultUpcomingRepository(
            api = get()
        )
    }
}