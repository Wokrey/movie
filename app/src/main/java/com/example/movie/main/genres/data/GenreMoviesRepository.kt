package com.example.movie.main.genres.data

import com.example.movie.base.api.Response
import com.example.movie.main.genres.data.model.GenreMoviesRequestModel
import com.example.movie.main.genres.data.model.GenreMoviesResponse

/**
 * Created by wokrey@gmail.com on 9/6/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
interface GenreMoviesRepository {
    suspend fun getMoviesByGenre(model: GenreMoviesRequestModel): Response<GenreMoviesResponse>
}