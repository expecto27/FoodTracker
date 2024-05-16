package com.example.foodtracker.domain.models

data class UserData(
    val name: String,
    val age: Int,
    val gender: Boolean,
    val height: Height,
    val weight: Weight,
    val target: Target
)
