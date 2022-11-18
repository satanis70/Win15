package com.example.win15.retrofit

import com.example.win15.models.FaqModel
import com.example.win15.models.StrategyModel
import com.example.win15.models.TipsModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiAviator {
    @GET("tipsandtricks.json")
    fun getTips(): Call<TipsModel>
    @GET("aviatorbettingstrategy.json")
    fun getStrategy():Call<StrategyModel>
    @GET("faq.json")
    fun getFaq():Call<FaqModel>
}