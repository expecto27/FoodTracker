package com.example.foodtracker.domain.usecase

import com.example.foodtracker.domain.models.MyProduct
import com.example.foodtracker.domain.repository.ProductRepository

class SaveMyProduct(
    val productRepository: ProductRepository
) {
    fun execute(product: MyProduct){
        productRepository.save(product)
    }
}