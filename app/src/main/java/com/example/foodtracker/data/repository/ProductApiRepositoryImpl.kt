package com.example.foodtracker.data.repository

import com.example.foodtracker.data.net.Network
import com.example.foodtracker.domain.models.ProductFromAPI
import com.example.foodtracker.domain.repository.ProductApiRepository
import retrofit2.Call
import retrofit2.await

class ProductApiRepositoryImpl : ProductApiRepository {
    override fun getSearchData(query: String?): Call<List<ProductFromAPI>> {
        return Network.getAPI().getData(query)
    }

    override fun findById(id: Int): Call<List<ProductFromAPI>> {
        return Network.getAPI().getDataById(id)
    }

    override fun check(): Boolean {
        val resp = Network.getAPI().getDataById(1)
        return resp.execute().isSuccessful
    }
}