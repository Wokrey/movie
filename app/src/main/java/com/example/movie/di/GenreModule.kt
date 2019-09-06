package com.example.movie.di

import com.example.movie.main.genres.data.DefaultGenresRepository
import com.example.movie.main.genres.data.GenresRepository
import com.example.movie.main.genres.domain.GenresViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by wokrey@gmail.com on 9/6/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */

val genreModule = module {

    viewModel<GenresViewModel> {
        GenresViewModel(
            repository = get()
        )
    }
    factory<GenresRepository> {
        DefaultGenresRepository(
            api = get()
        )
    }
}