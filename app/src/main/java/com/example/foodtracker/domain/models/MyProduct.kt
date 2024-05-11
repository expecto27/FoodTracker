package com.example.foodtracker.domain.models


data class MyProduct(
    val id: Int,
    val name: String,
    val calories: Float,
    val protein: Float?,
    val fat: Float?,
    val carbohydrates: Float?
)

