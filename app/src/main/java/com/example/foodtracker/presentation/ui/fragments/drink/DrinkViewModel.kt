package com.example.foodtracker.presentation.ui.fragments.drink

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodtracker.domain.models.DrinkDomain
import com.example.foodtracker.domain.usecase.DeleteDrink
import com.example.foodtracker.domain.usecase.GetDailyTarget
import com.example.foodtracker.domain.usecase.GetDrinkStat
import com.example.foodtracker.domain.usecase.SaveDrink
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class DrinkViewModel @Inject constructor(
    private val getDrinkStat: GetDrinkStat,
    private val saveDrink: SaveDrink,
    private val getDailyTarget: GetDailyTarget,
    private val deleteDrink: DeleteDrink
) : ViewModel() {

    private val _drinkStat = MutableLiveData<Int>()
    val drinkStat: LiveData<Int> get() = _drinkStat

    private var target: Int = 0

    init {
        getDrinkStat()
        getTargetDB()
    }

    fun getTarget(): Int {
        return target
    }

    private fun getTargetDB() {
        target = getDailyTarget.getDailyDrink()
    }

    fun getDrinkStat() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                calculateDrinkStat()
            }
            _drinkStat.postValue(result)
        }
    }

    private suspend fun calculateDrinkStat(): Int {
        val stat = getDrinkStat.execute()
        var res = 0
        stat.forEach { item ->
            res += item.ml
        }
        return res
    }
    fun saveDrink(ml: Int, day: Date) {
        viewModelScope.launch(Dispatchers.IO) {
            saveDrink.execute(DrinkDomain(null, ml, day))
        }
    }

    fun deleteDrink(){
        viewModelScope.launch(Dispatchers.IO) {
            deleteDrink.execute()
        }
    }
}