package com.example.foodtracker.data.repository

import com.example.foodtracker.domain.repository.ProductRepository

class ProductRepositoryImpl: ProductRepository {
    override fun save(): Boolean {
        return true
    }

    override fun getAll() {

    }
}