package com.example.foodtracker.domain.repository

import com.example.foodtracker.data.models.Product

interface ProductRepository {
    suspend fun save(product: Product)
    suspend fun getAll() : List<Product>
    suspend fun findByName(name: String) : List<Product>
}