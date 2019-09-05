package com.example.movie.main.films.data

import com.example.movie.base.api.ApiService
import com.example.movie.base.api.Response
import com.example.movie.main.films.data.model.UpcomingRequestModel
import com.example.movie.main.films.data.model.UpcomingResponse
import java.lang.Exception

/**
 * Created by wokrey@gmail.com on 9/5/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class DefaultUpcomingRepository(
    private val api: ApiService
) : UpcomingRepository {

    override suspend fun getUpcomingMovies(model: UpcomingRequestModel): Response<UpcomingResponse> = try {
        val response = api.getUpcoming(language = model.language, page = model.page).await()

        Response.Success(response)
    } catch (ex: Exception) {
        Response.Error(ex)
    }
}