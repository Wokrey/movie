package com.example.movie.main.films.data.model

import com.example.movie.utils.Constants

/**
 * Created by wokrey@gmail.com on 9/5/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */

data class UpcomingRequestModel(
    val language: String = Constants.RUSSIAN_LANGUAGE,
    val page: Int = 1
)

data class UpcomingResponse(
    val page: Int,
    val results: List<UpcomingMovie>
)

data class UpcomingMovie(
    val id: Int?,
    val original_title: String?,
    val poster_path: String?,
    val release_date: String?
)