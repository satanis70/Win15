package com.example.win15.models


import com.google.gson.annotations.SerializedName

data class FaqModel(
    @SerializedName("faq")
    val faq: List<Faq>
)