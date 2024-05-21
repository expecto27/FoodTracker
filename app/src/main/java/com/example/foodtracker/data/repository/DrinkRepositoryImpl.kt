package com.example.foodtracker.data.repository

import com.example.foodtracker.data.database.dao.DrinkStatDao
import com.example.foodtracker.data.mappers.DrinkDomainToDrinkMap
import com.example.foodtracker.data.mappers.DrinkToDrinkDomainMap
import com.example.foodtracker.domain.models.DrinkDomain
import com.example.foodtracker.domain.repository.DrinkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class DrinkRepositoryImpl(private val drinkStatDao: DrinkStatDao) : DrinkRepository {
    override fun getCurrentDate(): List<DrinkDomain> {
        val res = mutableListOf<DrinkDomain>()
        runBlocking(Dispatchers.IO) {
            drinkStatDao.getAll().map {
                res.add(DrinkToDrinkDomainMap.map(it))
            }
        }
        return res
    }

    override fun save(item: DrinkDomain) {
        drinkStatDao.save(
            DrinkDomainToDrinkMap.map(
                item
            )
        )
    }

    override fun delete() {
        drinkStatDao.delete()
    }
}