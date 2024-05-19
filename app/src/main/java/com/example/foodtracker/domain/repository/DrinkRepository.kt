package com.example.foodtracker.domain.repository

import com.example.foodtracker.domain.models.DrinkDomain

interface DrinkRepository {
    fun getCurrentDate(): DrinkDomain
    fun save(item: DrinkDomain)
}