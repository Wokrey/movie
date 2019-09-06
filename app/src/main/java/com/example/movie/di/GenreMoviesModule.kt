package com.example.movie.di

import com.example.movie.main.genres.data.DefaultGenreMoviesRepository
import com.example.movie.main.genres.data.GenreMoviesRepository
import com.example.movie.main.genres.domain.GenreMoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by wokrey@gmail.com on 9/6/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */

val genreMoviesModule = module {
    viewModel<GenreMoviesViewModel> {
        GenreMoviesViewModel(
            repository = get()
        )
    }
    factory<GenreMoviesRepository> {
        DefaultGenreMoviesRepository(
            api = get()
        )
    }
}