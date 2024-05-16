package com.example.foodtracker.presentation.ui.fragments.product

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodtracker.domain.models.EatingDomain
import com.example.foodtracker.domain.models.Meal
import com.example.foodtracker.domain.usecase.SaveEating
import com.example.foodtracker.presentation.mapper.MealToIntMap
import com.example.foodtracker.presentation.ui.adapters.CalendarAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject
@HiltViewModel
class ProductViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val saveEating: SaveEating
) : ViewModel() {
    fun saveEating(
        id: Int?,
        localId: Int?,
        serverId: Int?,
        meal: Meal,
        weight: Int
        ){
        val date = CalendarAdapter().getDate(Calendar.getInstance())
        viewModelScope.launch(Dispatchers.IO) {
            saveEating.execute(
                EatingDomain(
                    id = id,
                    localId = localId,
                    serverId = serverId,
                    meal = MealToIntMap.map(meal),
                    weight = weight,
                    day = date
                )
            )
        }
    }
}