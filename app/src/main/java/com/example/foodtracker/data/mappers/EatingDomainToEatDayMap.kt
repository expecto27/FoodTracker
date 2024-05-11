package com.example.foodtracker.data.mappers

import com.example.foodtracker.data.models.EatDay
import com.example.foodtracker.domain.models.EatingDomain

object EatingDomainToEatDayMap: Mapper<EatingDomain, EatDay> {
    override fun map(item: EatingDomain): EatDay {
        return EatDay(
            id = item.id,
            serverId = item.serverId,
            localId = item.localId,
            day = item.day,
            meal = item.meal,
            weight = item.weight
        )
    }
}