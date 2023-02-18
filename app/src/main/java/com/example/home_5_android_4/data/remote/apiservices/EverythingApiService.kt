package com.example.home_5_android_4.data.remote.apiservices

import com.example.home_5_android_4.data.models.news.ArticlesItem
import com.example.home_5_android_4.data.models.news.NewsResponce
import retrofit2.http.GET
import retrofit2.http.Query

interface EverythingApiService {

    @GET("everything")
    suspend fun fetchEverything(
      @Query("q") newQ : String
    ): NewsResponce<ArticlesItem>
}