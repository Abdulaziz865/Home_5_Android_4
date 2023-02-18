package com.example.home_5_android_4.data.models.source

import com.google.gson.annotations.SerializedName

data class SourcesItem(
    @SerializedName("country")
    val country: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("language")
    val language: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("category")
    val category: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("urlToImage")
    val urlToImage: String = ""
)