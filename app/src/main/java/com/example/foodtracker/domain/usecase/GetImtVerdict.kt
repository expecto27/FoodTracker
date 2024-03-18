package com.example.foodtracker.domain.usecase

import com.example.foodtracker.domain.models.ImtVerdict
import com.example.foodtracker.domain.models.IndexIMT

class GetImtVerdict {
    companion object {
        fun execute(indexIMT: IndexIMT): ImtVerdict {
            return when (indexIMT.value) {
                in 0.0..16.0 -> {
                    ImtVerdict.SevereBodyWeightDeficiency
                }

                in 16.0..18.5 -> {
                    ImtVerdict.InsufficientBodyWeight
                }

                in 18.5..25.0 -> {
                    ImtVerdict.Standard
                }

                in 25.0..30.0 -> {
                    ImtVerdict.Overweight
                }

                in 30.0..35.0 -> {
                    ImtVerdict.FirstDegreeObesity
                }

                in 35.0..40.0 -> {
                    ImtVerdict.SecondDegreeObesity
                }

                else -> {
                    ImtVerdict.ThirdDegreeObesity
                }
            }
        }
    }
}