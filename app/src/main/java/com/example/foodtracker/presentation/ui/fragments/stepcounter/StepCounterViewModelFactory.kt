package com.example.foodtracker.presentation.ui.fragments.stepcounter

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class StepCounterViewModelFactory(private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(StepCounterViewModel::class.java)){
            return StepCounterViewModel(application) as T
        }
        throw IllegalArgumentException("")
    }
}