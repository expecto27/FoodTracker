package com.example.foodtracker.domain.usecase

import com.example.foodtracker.domain.models.DrinkDomain
import com.example.foodtracker.domain.repository.DrinkRepository

class SaveDrink(private val drinkRepository: DrinkRepository){
    fun execute(item: DrinkDomain){
        drinkRepository.save(item)
    }
}