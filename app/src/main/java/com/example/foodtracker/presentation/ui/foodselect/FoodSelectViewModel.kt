package com.example.foodtracker.presentation.ui.foodselect

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodtracker.domain.models.ProductFromAPI
import com.example.foodtracker.domain.repository.ProductRepository
import com.example.foodtracker.domain.usecase.SearchProducts
import com.example.foodtracker.presentation.ui.models.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class FoodSelectViewModel @Inject constructor(
    private var savedStateHandle: SavedStateHandle,
    private var productRepository: ProductRepository,
    private var searchProducts: SearchProducts
) : ViewModel() {

    private val _searchData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val searchData: LiveData<String>
        get() = _searchData

    private val _products: MutableLiveData<List<Product>> by lazy {
        MutableLiveData()
    }
    val products: LiveData<List<Product>>
        get() = _products


    fun setLivaDataText(value: String) {
        _searchData.value = value
    }

    fun loadMyFood() {
        var products = viewModelScope.async(Dispatchers.Default) {
            val resultFromAPI = searchProducts.execute(_searchData.value).execute()
                val productList = if(resultFromAPI.isSuccessful) { resultFromAPI.body()?.map { item ->
                    Product(
                        name = item.productName,
                        calories = item.energyKcal100g,
                        protein = item.proteins100g,
                        fat = item.fat100g,
                        carbohydrates = item.carbohydrates100g
                    )
                }
            } else {
                null
            }
            productList
        }
        viewModelScope.launch {
            _products.value = products.await()
        }
    }
}