package com.example.win15.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitCreate {
    fun create(): ApiAviator {
        val api = ApiAviator::class.java
        val aviatorApi = Retrofit.Builder()
            .baseUrl("http://49.12.202.175/win15/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
        return aviatorApi
    }
}