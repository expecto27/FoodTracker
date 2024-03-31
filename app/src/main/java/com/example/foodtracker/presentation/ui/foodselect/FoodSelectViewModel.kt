package com.example.foodtracker.presentation.ui.foodselect

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FoodSelectViewModel: ViewModel() {
    private val _searchData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val searchData: LiveData<String>
        get() = _searchData

    fun setLivaDataText(value : String){
        _searchData.value = value
    }

}