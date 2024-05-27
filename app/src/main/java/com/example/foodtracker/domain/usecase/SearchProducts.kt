package com.example.foodtracker.domain.usecase

import com.example.foodtracker.domain.models.ProductFromAPI
import com.example.foodtracker.domain.repository.ProductApiRepository

class SearchProducts(private val rep: ProductApiRepository) {
    fun execute(query: String?): List<ProductFromAPI>? {
        return rep.getSearchData(query)
    }
}