package com.example.foodtracker.data.repository

import android.util.Log
import com.example.foodtracker.data.database.dao.EatDayDao
import com.example.foodtracker.data.mappers.EatDayToEatingDomainMap
import com.example.foodtracker.data.mappers.EatingDomainToEatDayMap
import com.example.foodtracker.domain.models.EatingDomain
import com.example.foodtracker.domain.repository.EatingRepository
import kotlinx.coroutines.runBlocking

class EatingRepositoryImpl(private val eatDayDao: EatDayDao) : EatingRepository{
    override fun save(eating: EatingDomain) {
        runBlocking {
            eatDayDao.save(EatingDomainToEatDayMap.map(eating))
        }
    }

    override fun getWithCurrentDate() : List<EatingDomain>{
        val res = mutableListOf<EatingDomain>()
        runBlocking {
            eatDayDao.getAll( ).map {
                res.add(EatDayToEatingDomainMap.map(it))
            }
        }
        //Log.d("DataBaseAnswer", res.size.toString())
        return res
    }
}