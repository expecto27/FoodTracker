package com.example.foodtracker.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodtracker.domain.models.Meal

class SharedViewModel: ViewModel() {
    private val _meal = MutableLiveData<Meal?>()

    val meal : LiveData<Meal?> = _meal

    fun setMeal(meal : Meal?){
        _meal.value = meal
    }

}