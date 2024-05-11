package com.example.foodtracker.presentation.mapper

import com.example.foodtracker.domain.models.Meal

interface Mapper<P, O> {
    fun map(item: P) : O
}
object MealToIntMap: Mapper<Meal, Int> {
    override fun map(item: Meal): Int {
        return when(item){
            Meal.Breakfast -> 0
            Meal.Lunch -> 1
            Meal.Dinner -> 2
            Meal.Other -> 3
        }
    }
}
object IntToMeal: Mapper<Int, Meal>{
    override fun map(item: Int): Meal {
        return when(item){
            0 -> Meal.Breakfast
            1 -> Meal.Lunch
            2 -> Meal.Dinner
            else -> {Meal.Other}
        }
    }
}