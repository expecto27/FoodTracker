package com.example.foodtracker.presentation.ui.foodselect

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodtracker.data.models.Product
import com.example.foodtracker.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class FoodSelectViewModel @Inject constructor(
    private var savedStateHandle: SavedStateHandle,
    private var productRepository: ProductRepository
): ViewModel() {
    private val _searchData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val searchData: LiveData<String>
        get() = _searchData

    fun setLivaDataText(value : String){
        _searchData.value = value
    }

    fun loadMyFood(){
        viewModelScope.launch(Dispatchers.Default) {
            val lst = productRepository.getAll()
            for(item in lst){
                Log.d("dsds", item.toString())
            }
        }
    }

}