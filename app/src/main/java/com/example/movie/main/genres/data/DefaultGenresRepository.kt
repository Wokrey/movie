package com.example.movie.main.genres.data

import com.example.movie.base.api.ApiService
import com.example.movie.base.api.Response
import com.example.movie.main.genres.data.model.GenresRequestModel
import com.example.movie.main.genres.data.model.GenresResponse

/**
 * Created by wokrey@gmail.com on 9/6/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class DefaultGenresRepository(
    private val api: ApiService
) : GenresRepository {

    override suspend fun getGenres(model: GenresRequestModel): Response<GenresResponse> = try {
        val response = api.getGenresList(language = model.language).await()

        Response.Success(response)
    } catch (ex: Exception) {
        Response.Error(ex)
    }


}