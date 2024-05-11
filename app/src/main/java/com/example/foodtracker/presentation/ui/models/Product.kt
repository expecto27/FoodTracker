package com.example.foodtracker.presentation.ui.models

data class Product(
    val id: Int,
    val name: String?,
    val image_url: String?,
    val image_small_url: String?,
    val brands: String?,
    val categories: String?,
    val calories: Float?,
    val protein: Float?,
    val fat: Float?,
    val carbohydrates: Float?
)