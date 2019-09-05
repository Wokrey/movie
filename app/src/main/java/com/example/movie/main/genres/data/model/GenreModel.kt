package com.example.movie.main.genres.data.model

import com.example.movie.utils.Constants

/**
 * Created by wokrey@gmail.com on 9/6/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */

data class GenresRequestModel(
    val language: String = Constants.RUSSIAN_LANGUAGE
)

data class GenresResponse(
    val genres: List<Genre>
)

data class Genre(
    val id: Int,
    val name: String
)

//movies by genre

data class GenreMoviesRequestModel(
    val language: String = Constants.RUSSIAN_LANGUAGE,
    val page: Int = 1,
    val with_genres: String
)

data class GenreMoviesResponse(
    val page: Int = 1,
    val results: List<Movie>
)

data class Movie(
    val popularity: Double?,
    val vote_count: Int?,
    val poster_path: String?,
    val id: Int?,
    val adult: Boolean?,
    val backdrop_path: String?,
    val original_language: String?,
    val original_title: String?,
    val genre_ids: List<Int>?,
    val title: String?,
    val vote_average: Double?,
    val overview: String?,
    val release_date: String?
)