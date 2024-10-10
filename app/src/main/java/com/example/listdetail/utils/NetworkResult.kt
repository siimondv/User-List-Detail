package com.example.listdetail.utils

sealed class NetworkResult<T>(
    var data: T? = null,
    var message: String? = null
) {

    class Success<T>(data: T) : NetworkResult<T>(data = data)

    class Error<T>(message: String = "", data: T? = null) : NetworkResult<T>(data = data, message = message)

    class Loading<T> : NetworkResult<T>()
}