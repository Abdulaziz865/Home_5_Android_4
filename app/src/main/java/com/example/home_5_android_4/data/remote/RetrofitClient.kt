package com.example.home_5_android_4.data.remote

import com.example.home_5_android_4.data.remote.apiservices.EverythingApiService
import com.example.home_5_android_4.data.remote.apiservices.SourceApiService
import com.example.home_5_android_4.data.remote.apiservices.TopHeadlinesApiService
import com.example.home_5_android_4.data.remote.interceptor.ApiKeyInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(provideLoggingInterceptor())
        .addInterceptor(ApiKeyInterceptor())
        .callTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(ApiKeyInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    private fun provideLoggingInterceptor() = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    fun provideEverythingApiService(): EverythingApiService = retrofitClient.create(EverythingApiService::class.java)

    fun provideTopHeadlinesApiService(): TopHeadlinesApiService = retrofitClient.create(TopHeadlinesApiService::class.java)

    fun provideSourceApiService(): SourceApiService = retrofitClient.create(SourceApiService::class.java)
}