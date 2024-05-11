package com.example.foodtracker.data.mappers

import com.example.foodtracker.data.models.Product
import com.example.foodtracker.domain.models.MyProduct

object MyProductToProductMap: Mapper<MyProduct, Product> {
    override fun map(item: MyProduct): Product {
        return Product(
            id = item.id,
            name = item.name,
            calories = item.calories,
            protein = item.protein,
            fat = item.fat,
            carbohydrates = item.carbohydrates
        )
    }
}