package com.example.movie.main.genres.data

import com.example.movie.base.api.ApiService
import com.example.movie.base.api.Response
import com.example.movie.main.genres.data.model.GenreMoviesRequestModel
import com.example.movie.main.genres.data.model.GenreMoviesResponse

/**
 * Created by wokrey@gmail.com on 9/6/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class DefaultGenreMoviesRepository(
    private val api: ApiService
): GenreMoviesRepository {

    override suspend fun getMoviesByGenre(model: GenreMoviesRequestModel): Response<GenreMoviesResponse> = try {
        val result = api.getMoviesByGenre(
            language = model.language,
            page = model.page,
            withGenres = model.with_genres
        ).await()

        Response.Success(result)
    } catch (ex: Exception) {

        Response.Error(error = ex)
    }
}