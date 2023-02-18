package com.example.home_5_android_4.data.models.source

import com.google.gson.annotations.SerializedName

data class SourceResponce<T>(
    @SerializedName("sources")
    val sources: List<SourcesItem>?,
    @SerializedName("status")
    val status: String = ""
)