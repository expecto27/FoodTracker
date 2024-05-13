package com.example.foodtracker.data.mappers

import com.example.foodtracker.data.models.EatDay
import com.example.foodtracker.domain.models.EatingDomain

object EatDayToEatingDomainMap: Mapper<EatDay, EatingDomain> {
    override fun map(item: EatDay): EatingDomain {
        return EatingDomain(
            id = item.id,
            serverId = item.serverId,
            localId = item.localId,
            day = item.day,
            meal = item.meal,
            weight = item.weight
        )
    }
}