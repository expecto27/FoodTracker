package com.example.foodtracker.data.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


object Network {
    private val BASE_URL = "http://10.0.2.2:3000"
    private val okHttpClient:OkHttpClient? = OkHttpClient.Builder()
    .connectTimeout(5, TimeUnit.SECONDS) // время ожидания подключения
    .readTimeout(5, TimeUnit.SECONDS) //  время ожидания чтения данных
    .writeTimeout(5, TimeUnit.SECONDS) // время ожидания записи данных
    .build()
    private var retrofit : Retrofit = Retrofit.Builder().client(okHttpClient!!).addConverterFactory(
        GsonConverterFactory.create()
    ).baseUrl(BASE_URL).build()

    fun getAPI(): FoodTrackerAPI {
        return retrofit.create(FoodTrackerAPI::class.java)
    }

}