package com.example.foodtracker.domain.usecase

import com.example.foodtracker.domain.models.Height
import com.example.foodtracker.domain.models.IndexIMT
import com.example.foodtracker.domain.models.Weight

class CalculateIMT {
    companion object {
        fun execute(weight: Weight, height: Height): IndexIMT {
            return IndexIMT(weight.value / ((height.value / 100) * (height.value / 100)))
        }
    }
}