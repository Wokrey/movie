package com.example.movie.main.films.domain

import androidx.lifecycle.MutableLiveData
import com.example.movie.base.BaseViewModel
import com.example.movie.base.api.Response
import com.example.movie.main.films.data.UpcomingRepository
import com.example.movie.main.films.data.model.UpcomingMovie
import com.example.movie.main.films.data.model.UpcomingRequestModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by wokrey@gmail.com on 9/5/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */

//TODO rename soonOn to upcoming everywhere

class UpcomingViewModel(
    private val repository: UpcomingRepository
) : BaseViewModel() {

    val upcomingMoviesLD = MutableLiveData<List<UpcomingMovie>>()

    fun loadUpcomingMovies() = launch(uiContext) {
        val response = withContext(bg) {
            repository.getUpcomingMovies(model = UpcomingRequestModel())
        }

        when (response) {
            is Response.Success -> upcomingMoviesLD.value = response.result.results
            is Response.Error -> errorLD.value = response.error
        }
    }
}