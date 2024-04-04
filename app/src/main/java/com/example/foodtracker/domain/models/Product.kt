package com.example.foodtracker.domain.models

data class Product(
    val name: String,
    val calories: Float,
    val protein: Float?,
    val fat: Float?,
    val carbohydrates: Float?
)