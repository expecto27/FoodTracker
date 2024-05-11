package com.example.foodtracker.domain.usecase

import com.example.foodtracker.domain.models.EatingDomain
import com.example.foodtracker.domain.repository.EatingRepository

class SaveEating(private val eatingRepository: EatingRepository) {
    fun execute(eating: EatingDomain){
        eatingRepository.save(eating)
    }
}