package com.example.win15.models


import com.google.gson.annotations.SerializedName

data class TipsModel(
    @SerializedName("tipsandtricks")
    val tipsandtricks: List<Tipsandtrick>
)