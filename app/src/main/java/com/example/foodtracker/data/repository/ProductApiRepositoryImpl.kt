package com.example.foodtracker.data.repository

import com.example.foodtracker.data.net.Network
import com.example.foodtracker.domain.models.ProductFromAPI
import com.example.foodtracker.domain.repository.ProductApiRepository
import retrofit2.Call

class ProductApiRepositoryImpl: ProductApiRepository {
    override fun getSearchData(query: String?): Call<List<ProductFromAPI>> {
        return Network.getAPI().getData(query)
    }
}