package com.example.home_5_android_4.data.repositories

import com.example.home_5_android_4.base.BaseRepository
import com.example.home_5_android_4.data.remote.apiservices.SourceApiService
import com.example.home_5_android_4.data.remote.apiservices.TopHeadlinesApiService
import javax.inject.Inject

class SourceRepository @Inject constructor(private val apiService: SourceApiService): BaseRepository() {

    fun fetchSource(newQ : String) = doRequest{
        apiService.fetchSource(newQ)
    }
}