package com.example.foodtracker.domain.models

import kotlin.math.round

data class IndexIMT(var value: Double){
    init{
        require(value > 0 && value < 100)
        value = ((value * 100).toInt().toDouble() / 100)
    }
}
