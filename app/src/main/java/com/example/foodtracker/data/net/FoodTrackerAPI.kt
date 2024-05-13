package com.example.foodtracker.data.net

import com.example.foodtracker.domain.models.ProductFromAPI
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodTrackerAPI {
    @GET("api/foods")
    fun getData(@Query("title") productName: String?) : Call<List<ProductFromAPI>>

    @GET("api/food")
    fun getDataById(@Query("id") id: Int) : Call<List<ProductFromAPI>>
}