package com.example.foodtracker.presentation.ui.fragments.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodtracker.domain.models.DailyTarget
import com.example.foodtracker.domain.models.EatingDomain
import com.example.foodtracker.domain.usecase.DeleteEating
import com.example.foodtracker.domain.usecase.GetDailyTarget
import com.example.foodtracker.domain.usecase.GetEating
import com.example.foodtracker.domain.usecase.GetUserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private var savedStateHandle: SavedStateHandle,
    private var getEating: GetEating,
    private var getDailyTarget: GetDailyTarget,
    private var getUserData: GetUserData,
    private val deleteEating: DeleteEating
) : ViewModel() {

    private val _protein: MutableLiveData<Float> by lazy {
        MutableLiveData<Float>()
    }
    val protein: LiveData<Float>
        get() = _protein


    fun getAllEating(): Deferred<List<EatingDomain>> {
        return viewModelScope.async(Dispatchers.IO) {
            getEating.getCurrentDate()
        }
    }
    fun getDeleteEating(): DeleteEating{
        return deleteEating
    }
    fun getTarget(): DailyTarget {
        return getDailyTarget.execute()
    }

    fun getUserName() : String {
        return getUserData.execute().name
    }
}