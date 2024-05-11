package com.example.foodtracker.data.repository

import com.example.foodtracker.data.database.dao.EatDayDao
import com.example.foodtracker.data.mappers.EatingDomainToEatDayMap
import com.example.foodtracker.domain.models.EatingDomain
import com.example.foodtracker.domain.repository.EatingRepository

class EatingRepositoryImpl(private val eatDayDao: EatDayDao) : EatingRepository{
    override fun save(eating: EatingDomain) {
        eatDayDao.save(EatingDomainToEatDayMap.map(eating))
    }

}