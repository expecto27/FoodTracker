package com.example.foodtracker.data.mappers

import com.example.foodtracker.data.models.DrinkStat
import com.example.foodtracker.domain.models.DrinkDomain

object DrinkToDrinkDomainMap: Mapper<DrinkStat, DrinkDomain> {
    override fun map(item: DrinkStat): DrinkDomain {
        return DrinkDomain(
            item.id,
            item.ml,
            item.day
        )
    }
}