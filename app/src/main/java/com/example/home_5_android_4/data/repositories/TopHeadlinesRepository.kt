package com.example.home_5_android_4.data.repositories

import com.example.home_5_android_4.base.BaseRepository
import com.example.home_5_android_4.data.remote.apiservices.TopHeadlinesApiService
import javax.inject.Inject

class TopHeadlinesRepository @Inject constructor(private val apiService: TopHeadlinesApiService): BaseRepository() {

    fun fetchTopHeadlines(newQ : String) = doRequest{
        apiService.fetchTopHeadlines(newQ)
    }
}