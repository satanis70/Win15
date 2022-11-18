package com.example.win15.models


import com.google.gson.annotations.SerializedName

data class Tipsandtrick(
    @SerializedName("definition")
    val definition: String,
    @SerializedName("title")
    val title: String
)