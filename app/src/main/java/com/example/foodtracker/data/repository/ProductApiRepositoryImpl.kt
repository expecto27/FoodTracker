package com.example.foodtracker.data.repository

import com.example.foodtracker.data.net.Network
import com.example.foodtracker.domain.models.ProductFromAPI
import com.example.foodtracker.domain.repository.ProductApiRepository

class ProductApiRepositoryImpl : ProductApiRepository {
    override fun getSearchData(query: String?): List<ProductFromAPI>? {
        return Network.getAPI().getData(query).execute().body()
    }

    override fun findById(id: Int): List<ProductFromAPI>? {

        val res =  Network.getAPI().getDataById(id).execute().body()

        return res
    }

    override fun check(): Boolean {
        val resp = Network.getAPI().getDataById(1)
        return resp.execute().isSuccessful
    }
}