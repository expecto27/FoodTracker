package com.example.foodtracker.data.mappers

import com.example.foodtracker.data.models.Product
import com.example.foodtracker.domain.models.MyProduct

object ProductToMyProductMap : Mapper<Product, MyProduct>{
    override fun map(item: Product) : MyProduct {
        return MyProduct(
            id = item.id,
            name = item.name,
            calories = item.calories,
            protein = item.protein,
            fat = item.fat,
            carbohydrates = item.carbohydrates
        )
    }
}
