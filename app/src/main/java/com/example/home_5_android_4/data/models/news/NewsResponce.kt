package com.example.home_5_android_4.data.models.news

import com.google.gson.annotations.SerializedName

data class NewsResponce<T>(
    @SerializedName("totalResults")
    val totalResults: Int = 0,
    @SerializedName("articles")
    val articles: List<T>,
    @SerializedName("status")
    val status: String = ""
)