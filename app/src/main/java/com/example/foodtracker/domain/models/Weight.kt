package com.example.foodtracker.domain.models


data class Weight(val value: Double) {
    init {
        require(value > 0) { "Weight must be positive" }
    }
}
