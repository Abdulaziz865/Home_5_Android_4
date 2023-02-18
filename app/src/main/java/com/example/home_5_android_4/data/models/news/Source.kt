package com.example.home_5_android_4.data.models.news

import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("id")
    val id: String = ""
)