package com.example.foodtracker.domain.repository

import com.example.foodtracker.domain.models.EatingDomain

interface EatingRepository {
    fun save(eating: EatingDomain)
    fun getWithCurrentDate() : List<EatingDomain>
    fun delete(eating: EatingDomain)
}