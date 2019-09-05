package com.example.movie.main.films.data

import com.example.movie.base.api.ApiService
import com.example.movie.base.api.Response
import com.example.movie.main.films.data.model.PopularRequestModel
import com.example.movie.main.films.data.model.PopularResponse

/**
 * Created by wokrey@gmail.com on 9/5/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class DefaultPopularRepository(
    private val api: ApiService
): PopularRepository {

    override suspend fun getPopular(model: PopularRequestModel): Response<PopularResponse> = try{
        val response = api.getPopular(language = model.language, page = model.page).await()

        Response.Success(response)
    }catch (ex: Exception){
        Response.Error(ex)
    }
}