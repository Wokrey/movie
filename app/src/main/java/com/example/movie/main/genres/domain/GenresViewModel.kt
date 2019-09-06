package com.example.movie.main.genres.domain

import androidx.lifecycle.MediatorLiveData
import com.example.movie.base.BaseViewModel
import com.example.movie.base.api.Response
import com.example.movie.main.genres.data.GenresRepository
import com.example.movie.main.genres.data.model.Genre
import com.example.movie.main.genres.data.model.GenresRequestModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by wokrey@gmail.com on 9/6/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class GenresViewModel(
    private val repository: GenresRepository
) : BaseViewModel() {
    private val genresLD = MediatorLiveData<List<Genre>>()

    fun getGenres() = launch(uiContext) {
        val response = withContext(bg) {

            return@withContext repository.getGenres(GenresRequestModel())
        }

        when (response) {
            is Response.Success -> genresLD.value = response.result.genres
            is Response.Error -> errorLD.value = response.error
        }
    }

    fun getGenresLD() = genresLD
}