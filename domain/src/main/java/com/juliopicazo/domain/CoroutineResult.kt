package com.juliopicazo.domain

import java.lang.Exception

sealed class CoroutineResult<out T : Any> {

    class Success<out T : Any>(val data: T) : CoroutineResult<T>()
    class Failed(val exception: Exception) : CoroutineResult<Nothing>()

}