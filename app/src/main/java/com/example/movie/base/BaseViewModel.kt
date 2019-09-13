package com.example.movie.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlin.coroutines.CoroutineContext

/**
 * Created by wokrey@gmail.com on 9/5/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
open class BaseViewModel(
    protected val uiContext: CoroutineContext = Dispatchers.Main,
    protected val bg: CoroutineContext = Dispatchers.IO
): ViewModel(), CoroutineScope {

    protected val progressBarStatusLD = MutableLiveData<Boolean>()
    protected val errorLD = MutableLiveData<Exception>()
    private val job = Job()

    override val coroutineContext: CoroutineContext by lazy {
        uiContext + job
    }

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancelChildren()
    }

    //getters
    fun getErrorLD(): LiveData<Exception> = errorLD

    fun getProgressBarStatusLD(): LiveData<Boolean> = progressBarStatusLD
}