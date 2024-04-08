package com.example.foodtracker.domain.repository

import com.example.foodtracker.domain.models.ProductFromAPI

interface ProductApiRepository {
    fun getSearchData(query: String?): List<ProductFromAPI>
}