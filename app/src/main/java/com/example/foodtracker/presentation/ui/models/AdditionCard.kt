package com.example.foodtracker.presentation.ui.models

import com.example.foodtracker.presentation.ui.adapters.EatingCardAdapter

data class AdditionCard (
    override val imageId: Int,
    override val color: Int,
    override val title: String,
    val listener: () -> Unit
) : ICard
