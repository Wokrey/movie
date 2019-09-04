package com.example.movie.base.api

/**
 * Created by wokrey@gmail.com on 9/5/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */

sealed class Response<T> {

    data class Success<T>(
        val result: T
    ) : Response<T>()

    data class Error<T>(
        val error: Exception
    ) : Response<T>()
}