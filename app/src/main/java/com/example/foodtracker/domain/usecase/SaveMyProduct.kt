package com.example.foodtracker.domain.usecase

import com.example.foodtracker.domain.models.MyProduct
import com.example.foodtracker.domain.repository.ProductRepository
import javax.inject.Inject

class SaveMyProduct @Inject constructor(
    val productRepository: ProductRepository
) {
    fun execute(product: MyProduct){
        productRepository.save(product)
    }
}