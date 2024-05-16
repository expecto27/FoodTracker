package com.example.foodtracker.data.mappers

import com.example.foodtracker.domain.models.Target

object TargetConverter {
    fun toInt(target: Target): Int {
        return when (target) {
            Target.Grow -> 3
            Target.Stay -> 2
            Target.Lose -> 1
        }
    }

    fun toTarget(target: Int): Target {
        return when (target) {
            3 -> Target.Grow
            2 -> Target.Stay
            1 -> Target.Lose
            else -> {
                Target.Stay
            }
        }
    }
}
