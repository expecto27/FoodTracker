package com.example.foodtracker.domain.usecase

import com.example.foodtracker.domain.models.DailyTarget
import com.example.foodtracker.domain.models.Height
import com.example.foodtracker.domain.models.Target
import com.example.foodtracker.domain.models.Weight
import com.example.foodtracker.domain.repository.UserDataRepository

class GetDailyTarget(private val userDataRepository: UserDataRepository) {
    // Базовый метаболизм рассчитывается по формуле
    // BMR = [9.99 x вес (кг)] + [6.25 x рост (см)] - [4.92 x возраст (в годах)] + 5 (для мужчин) -161 (для женщин)
    fun execute(): DailyTarget {
        val userData = userDataRepository.getUserData()
        var dailyCaloriesTemp = getCalloriesFormulaSanJeorMiffline(
            userData.age,
            userData.weight,
            userData.height,
            userData.gender
        )
        when (userData.target) {
            Target.Stay -> {
                dailyCaloriesTemp += 0
            }

            Target.Lose -> {

            }

            Target.Grow -> {

            }
        }
        return DailyTarget(
            dailyCalories = dailyCaloriesTemp,
            dailyProteins = getDailyProtein(userData.weight),
            dailyCarbohydrates = getDailyCarbohydrates(),
            dailyFats = getDailyFats(userData.weight)
        )
    }

    private fun getCalloriesFormulaSanJeorMiffline(
        age: Int,
        weight: Weight,
        height: Height,
        gender: Boolean
    ): Float {
        return (
                (9.99 * weight.value) + (6.25 * height.value) - (4.92 * age) + if (gender) 5 else -161
                ).toFloat()
    }

    private fun getDailyProtein(weight: Weight): Float {
        return (weight.value * 0.75).toFloat()
    }

    private fun getDailyCarbohydrates(): Float {
        return 350f
        //TODO: весьма печально
    }

    private fun getDailyFats(weight: Weight): Float {
        return (0.8 * weight.value).toFloat()
    }

}