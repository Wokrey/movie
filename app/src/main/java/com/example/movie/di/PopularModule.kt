package com.example.movie.di

import com.example.movie.main.films.data.DefaultPopularRepository
import com.example.movie.main.films.data.PopularRepository
import com.example.movie.main.films.domain.PopularViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by wokrey@gmail.com on 9/5/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */

val popularModule = module {

    viewModel{
        PopularViewModel(
            repository = get()
        )
    }

    factory<PopularRepository> {
        DefaultPopularRepository(
            api = get()
        )
    }
}