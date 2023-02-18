package com.example.home_5_android_4.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder().addQueryParameter("apiKey", "33d73edbaed74d56aa0b9f0a319d522f").build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}