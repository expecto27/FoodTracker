package com.example.foodtracker.data.mappers

import com.example.foodtracker.data.models.Product
import com.example.foodtracker.domain.models.MyProduct

interface Mapper<P, O> {
    fun map(item: P) : O
}