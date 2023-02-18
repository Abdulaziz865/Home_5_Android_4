package com.example.home_5_android_4.data.repositories

import com.example.home_5_android_4.base.BaseRepository
import com.example.home_5_android_4.data.remote.apiservices.EverythingApiService
import javax.inject.Inject

class EverythingRepository @Inject constructor(private val apiService: EverythingApiService): BaseRepository() {

    fun fetchEverything(newQ : String) = doRequest{
        apiService.fetchEverything(newQ)
    }
}