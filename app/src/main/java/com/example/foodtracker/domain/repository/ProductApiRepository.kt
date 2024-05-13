package com.example.foodtracker.domain.repository

import com.example.foodtracker.domain.models.MyProduct
import com.example.foodtracker.domain.models.ProductFromAPI
import retrofit2.Call

interface ProductApiRepository {
    fun getSearchData(query: String?): Call<List<ProductFromAPI>>
    fun findById(id: Int) : Call<List<ProductFromAPI>>
}