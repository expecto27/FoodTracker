package com.example.foodtracker.data.repository

import com.example.foodtracker.data.database.dao.ProductDao
import com.example.foodtracker.data.mappers.MyProductToProductMap
import com.example.foodtracker.data.mappers.ProductToMyProductMap
import com.example.foodtracker.data.models.Product
import com.example.foodtracker.domain.models.MyProduct
import com.example.foodtracker.domain.repository.ProductRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking

class ProductRepositoryImpl(private val productDao: ProductDao) : ProductRepository {
    override fun save(product: MyProduct) {
        runBlocking{
            productDao.save(
                MyProductToProductMap().map(product)
            )
        }
    }

    override fun findByName(name: String): List<MyProduct> {
        val result = mutableListOf<MyProduct>()
        var temp : List<Product>
        runBlocking {
            temp = productDao.findByName(name)
        }
        val mapper = ProductToMyProductMap()
        temp.map{
            result.add(mapper.map(it))
        }
        return result
    }

    override fun getAll(): List<MyProduct> {
        val result = mutableListOf<MyProduct>()
        var temp : List<Product>
        runBlocking {
            temp = productDao.getAll()
        }
        val mapper = ProductToMyProductMap()
        temp.map{
            result.add(mapper.map(it))
        }
        return result
    }
}
