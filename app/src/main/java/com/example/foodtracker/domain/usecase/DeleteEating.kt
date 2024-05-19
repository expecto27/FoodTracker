package com.example.foodtracker.domain.usecase

import com.example.foodtracker.domain.models.EatingDomain
import com.example.foodtracker.domain.repository.EatingRepository

class DeleteEating(private val eatingRepository: EatingRepository) {
    fun execute(item: EatingDomain){
        eatingRepository.delete(item)
    }
}