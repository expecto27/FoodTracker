package com.example.foodtracker.data.repository

import com.example.foodtracker.data.database.dao.ProductDao
import com.example.foodtracker.data.models.Product
import com.example.foodtracker.domain.repository.ProductRepository

class ProductRepositoryImpl(private val productDao: ProductDao) : ProductRepository {
    override suspend fun save(product: Product) {
        productDao.save(product)
    }

    override suspend fun findByName(name: String): List<Product> {
        return productDao.findByName(name)
    }

    override suspend fun getAll(): List<Product> {
        return productDao.getAll()
    }
}