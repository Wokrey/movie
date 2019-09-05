package com.example.movie.main.films.data

import com.example.movie.base.api.Response
import com.example.movie.main.films.data.model.UpcomingRequestModel
import com.example.movie.main.films.data.model.UpcomingResponse

/**
 * Created by wokrey@gmail.com on 9/5/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
interface UpcomingRepository {
    suspend fun getUpcomingMovies(model: UpcomingRequestModel): Response<UpcomingResponse>

}