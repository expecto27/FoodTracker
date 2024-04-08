package com.example.foodtracker.data.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    private val BASE_URL = "https://localhost:3000"
    private var retrofit : Retrofit = Retrofit.Builder().addConverterFactory(
        GsonConverterFactory.create()
    ).baseUrl(BASE_URL).build()

    fun getAPI(): FoodTrackerAPI {
        return retrofit.create(FoodTrackerAPI::class.java)
    }

}