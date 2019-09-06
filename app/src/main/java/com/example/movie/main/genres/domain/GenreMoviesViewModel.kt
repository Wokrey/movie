package com.example.movie.main.genres.domain

import androidx.lifecycle.MutableLiveData
import com.example.movie.base.BaseViewModel
import com.example.movie.base.api.Response
import com.example.movie.main.genres.data.GenreMoviesRepository
import com.example.movie.main.genres.data.model.GenreMoviesRequestModel
import com.example.movie.main.genres.data.model.Movie
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by wokrey@gmail.com on 9/6/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class GenreMoviesViewModel(
    private val repository: GenreMoviesRepository
): BaseViewModel() {
    val moviesLD = MutableLiveData<List<Movie>>()

    fun getGenreMovies(genreId: Int) = launch(uiContext){
        val response = withContext(bg){

            return@withContext repository.getMoviesByGenre(GenreMoviesRequestModel(with_genres = genreId.toString()))
        }

        when(response){
            is Response.Success -> moviesLD.value = response.result.results
            is Response.Error -> errorLD.value = response.error
        }
    }
}