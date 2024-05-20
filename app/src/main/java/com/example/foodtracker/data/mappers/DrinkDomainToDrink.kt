package com.example.foodtracker.data.mappers

import com.example.foodtracker.data.models.DrinkStat
import com.example.foodtracker.domain.models.DrinkDomain

object DrinkDomainToDrink: Mapper<DrinkDomain, DrinkStat> {
    override fun map(item: DrinkDomain): DrinkStat {
        return DrinkStat(
            null,
            item.ml,
            item.day
        )
    }
}