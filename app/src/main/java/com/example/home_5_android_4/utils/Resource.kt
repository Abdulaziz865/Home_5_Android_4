package com.example.home_5_android_4.utils

sealed class Resource<out T>(
    val data: T? = null,
    val message: String? = null
) {
    class Loading<T>(data: T? = null) : Resource<T>(data = data)

    class Success<T>(data: T) : Resource<T>(data = data)

    class Failure<T>(message: String, data: T? = null) : Resource<T>(data = data, message = message)
}