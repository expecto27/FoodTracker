package com.example.foodtracker.domain.models

data class DailyTarget(
    val dailyCalories: Float,
    val dailyProteins: Float,
    val dailyFats: Float,
    val dailyCarbohydrates: Float
)