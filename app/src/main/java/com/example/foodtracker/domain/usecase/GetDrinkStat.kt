package com.example.foodtracker.domain.usecase

import com.example.foodtracker.domain.models.DrinkDomain
import com.example.foodtracker.domain.repository.DrinkRepository

class GetDrinkStat(private val drinkRepository: DrinkRepository) {
    fun execute(): DrinkDomain{
        return drinkRepository.getCurrentDate()
    }
}