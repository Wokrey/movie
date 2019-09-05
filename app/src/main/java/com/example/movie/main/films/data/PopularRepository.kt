package com.example.movie.main.films.data

import com.example.movie.base.api.Response
import com.example.movie.main.films.data.model.PopularRequestModel
import com.example.movie.main.films.data.model.PopularResponse

/**
 * Created by wokrey@gmail.com on 9/5/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
interface PopularRepository {

    suspend fun getPopular(model: PopularRequestModel): Response<PopularResponse>
}