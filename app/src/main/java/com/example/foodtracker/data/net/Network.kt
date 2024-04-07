package com.example.foodtracker.data.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    private val instance by lazy {
        Network()
    }
    private val BASE_URL = "localhost:3000"
    private lateinit var retrofit : Retrofit
    fun getInstance(): Network {
        return instance
    }

    fun network(){
        retrofit = Retrofit.Builder().addConverterFactory(
            GsonConverterFactory.create()
        ).baseUrl(BASE_URL).build()
    }


}