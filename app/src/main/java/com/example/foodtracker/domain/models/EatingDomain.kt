package com.example.foodtracker.domain.models

import java.util.Date

data class EatingDomain(
    val id: Int?,
    val serverId: Int?,
    val localId: Int?,
    val day: Date,
    val meal: Int,
    val weight: Int
)
