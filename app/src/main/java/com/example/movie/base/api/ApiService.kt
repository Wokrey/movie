package com.example.movie.base.api

import com.example.movie.main.films.data.model.PopularResponse
import com.example.movie.main.films.data.model.UpcomingResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by wokrey@gmail.com on 9/4/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
interface ApiService {

    @GET("movie/popular")
    fun getPopular(
        @Query("language") language: String,
        @Query("page") page: Int
    ): Deferred<PopularResponse>

    @GET("movie/upcoming")
    fun getUpcoming(
        @Query("language") language: String,
        @Query("page") page: Int
    ): Deferred<UpcomingResponse>
}