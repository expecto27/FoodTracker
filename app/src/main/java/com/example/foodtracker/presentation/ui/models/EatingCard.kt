package com.example.foodtracker.presentation.ui.models

data class EatingCard(
    override val imageId: Int,
    override val color: Int,
    override val title: String,
    val changeListener: () -> Unit
):ICard
