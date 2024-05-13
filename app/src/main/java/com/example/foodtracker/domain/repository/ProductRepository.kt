package com.example.foodtracker.domain.repository

import com.example.foodtracker.domain.models.MyProduct


interface ProductRepository {
    fun save(product: MyProduct)
    fun getAll() : List<MyProduct>
    fun findByName(name: String) : List<MyProduct>

}