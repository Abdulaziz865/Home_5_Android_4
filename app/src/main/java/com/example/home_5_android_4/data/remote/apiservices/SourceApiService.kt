package com.example.home_5_android_4.data.remote.apiservices

import com.example.home_5_android_4.data.models.source.SourceResponce
import com.example.home_5_android_4.data.models.source.SourcesItem
import retrofit2.http.GET
import retrofit2.http.Query

interface SourceApiService {

    @GET("top-headlines/sources")
    suspend fun fetchSource(
        @Query("q") newQ : String
    ): SourceResponce<SourcesItem>

}