package com.example.foodtracker.domain.repository

import com.example.foodtracker.domain.models.DrinkDomain

interface DrinkRepository {
    fun getCurrentDate(): List<DrinkDomain>
    fun save(item: DrinkDomain)
    fun delete()
}