package com.example.foodtracker.domain.usecase

import com.example.foodtracker.domain.models.MyProduct
import com.example.foodtracker.domain.repository.ProductRepository

class SearchMyProducts (
    private val myProductRepository: ProductRepository
) {
    fun execute(query: String): List<MyProduct> {
        return myProductRepository.findByName(query)
    }
}