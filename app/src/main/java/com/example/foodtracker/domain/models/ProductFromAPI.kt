package com.example.foodtracker.domain.models

data class ProductFromAPI (
    val id: Int,
    val productName: String?,
    val quantity: String?,
    val packaging: String?,
    val brands: String?,
    val categories: String?,
    val stores: String?,
    val countries: String?,
    val servingSize: String?,
    val servingQuantity: String?,
    val nutritionScoreScore: Int?,
    val nutritionScoreGrade: String?,
    val imageUrl: String?,
    val imageSmallUrl: String?,
    val energyKj100g: Float?,
    val energyKcal100g: Float?,
    val energy100g: Float?,
    val energyFromFat100g: Float?,
    val fat100g: Float?,
    val saturatedFat100g: Float?,
    val carbohydrates100g: Float?,
    val proteins100g: Float?
)
