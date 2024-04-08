package com.example.foodtracker.domain.usecase

import com.example.foodtracker.domain.models.ProductFromAPI
import com.example.foodtracker.domain.repository.ProductApiRepository
import retrofit2.Call

class SearchProducts(private val rep: ProductApiRepository) {
    suspend fun execute(query: String?): Call<List<ProductFromAPI>> {
        return rep.getSearchData(query)
    }
}