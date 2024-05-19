package com.example.foodtracker.data.repository

import com.example.foodtracker.data.database.dao.DrinkStatDao
import com.example.foodtracker.data.mappers.DrinkDomainToDrink
import com.example.foodtracker.data.mappers.DrinkToDrinkDomain
import com.example.foodtracker.domain.models.DrinkDomain
import com.example.foodtracker.domain.repository.DrinkRepository

class DrinkRepositoryImpl(private val drinkStatDao: DrinkStatDao) : DrinkRepository {
    override fun getCurrentDate(): DrinkDomain {
        return DrinkToDrinkDomain.map(
            drinkStatDao.getWithCurrentDate()[0]
        )
    }

    override fun save(item: DrinkDomain) {
        drinkStatDao.save(
            DrinkDomainToDrink.map(
                item
            )
        )
    }
}