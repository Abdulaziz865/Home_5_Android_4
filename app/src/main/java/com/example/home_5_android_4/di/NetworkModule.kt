package com.example.home_5_android_4.di

import com.example.home_5_android_4.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitClient() = RetrofitClient()

    @Singleton
    @Provides
    fun provideEverythingApiService(retrofitClient: RetrofitClient) = retrofitClient.provideEverythingApiService()

    @Singleton
    @Provides
    fun provideTopHeadlinesApiService(retrofitClient: RetrofitClient) = retrofitClient.provideTopHeadlinesApiService()

    @Singleton
    @Provides
    fun provideSourceApiService(retrofitClient: RetrofitClient) = retrofitClient.provideSourceApiService()
}