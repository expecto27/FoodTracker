package com.example.foodtracker.domain.usecase

import com.example.foodtracker.domain.models.EatingDomain
import com.example.foodtracker.domain.repository.EatingRepository

class GetEating(private val eatingRepository: EatingRepository) {
    fun getCurrentDate() : List<EatingDomain>{
        return eatingRepository.getWithCurrentDate()
    }
}