package com.example.movie.main.films.data.model

import com.example.movie.utils.Constants

/**
 * Created by wokrey@gmail.com on 9/5/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */

data class PopularRequestModel(
    val language: String = Constants.RUSSIAN_LANGUAGE,
    val page: Int = 1
)

data class PopularResponse(
    val page: Int,
    val results: List<PopularMovie>
)

data class PopularMovie(
    val popularity: Double?,
    val vote_count: Int?,
    val video: Boolean?,
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