package com.example.win15.models


import com.google.gson.annotations.SerializedName

data class StrategyModel(
    @SerializedName("strategy")
    val strategy: List<Strategy>
)