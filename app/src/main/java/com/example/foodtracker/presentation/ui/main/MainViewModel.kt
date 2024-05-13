package com.example.foodtracker.presentation.ui.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodtracker.domain.models.EatingDomain
import com.example.foodtracker.domain.usecase.GetEating
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private var savedStateHandle: SavedStateHandle,
    private var getEating: GetEating
): ViewModel(){
    suspend fun getAllEating(): Deferred<List<EatingDomain>> {
        return viewModelScope.async(Dispatchers.IO) {
            getEating.getCurrentDate()
        }
    }
}