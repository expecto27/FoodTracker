package com.example.foodtracker.domain.usecase

import com.example.foodtracker.domain.repository.ProductApiRepository

class CheckServerConnection(private val productApiRepository: ProductApiRepository) {
    fun execute() : Boolean {
        return productApiRepository.check()
    }
}