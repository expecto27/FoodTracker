package com.example.foodtracker.data.repository

import com.example.foodtracker.data.database.dao.DrinkStatDao
import com.example.foodtracker.data.mappers.DrinkDomainToDrink
import com.example.foodtracker.data.mappers.DrinkToDrinkDomain
import com.example.foodtracker.domain.models.DrinkDomain
import com.example.foodtracker.domain.repository.DrinkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class DrinkRepositoryImpl(private val drinkStatDao: DrinkStatDao) : DrinkRepository {
    override fun getCurrentDate(): List<DrinkDomain> {
        val res = mutableListOf<DrinkDomain>()
        runBlocking(Dispatchers.IO) {
            drinkStatDao.getAll().map {
                res.add(DrinkToDrinkDomain.map(it))
            }
        }
        return res
    }

    override fun save(item: DrinkDomain) {
        drinkStatDao.save(
            DrinkDomainToDrink.map(
                item
            )
        )
    }

    override fun delete() {
        drinkStatDao.delete()
    }
}