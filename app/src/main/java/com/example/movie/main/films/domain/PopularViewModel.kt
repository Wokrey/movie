package com.example.movie.main.films.domain

import androidx.lifecycle.MutableLiveData
import com.example.movie.base.BaseViewModel
import com.example.movie.base.api.Response
import com.example.movie.main.films.data.PopularRepository
import com.example.movie.main.films.data.model.PopularMovie
import com.example.movie.main.films.data.model.PopularRequestModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by wokrey@gmail.com on 9/5/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class PopularViewModel(
    private val repository: PopularRepository
): BaseViewModel() {

    private val popularsLD = MutableLiveData<List<PopularMovie>>()

    fun loadPopulars() = launch(uiContext) {
        val response = withContext(bg){

            return@withContext repository.getPopular(model = PopularRequestModel())
        }

        when(response){
            is Response.Success -> popularsLD.value = response.result.results
            is Response.Error -> errorLD.value = response.error
        }
    }

    //getters
    fun getPopularsLD() = popularsLD
}