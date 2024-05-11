package com.example.foodtracker.presentation.ui.foodselect

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodtracker.domain.repository.ProductRepository
import com.example.foodtracker.domain.usecase.SearchProducts
import com.example.foodtracker.presentation.ui.models.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodSelectViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
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
        val products = viewModelScope.async(Dispatchers.IO) {
            val resultFromAPI = searchProducts.execute(_searchData.value).execute()
                val productList = if(resultFromAPI.isSuccessful) { resultFromAPI.body()?.map { item ->
                    Product(
                        id = item.id,
                        name = item.productName,
                        image_url = item.imageUrl,
                        image_small_url = item.imageSmallUrl,
                        calories = item.energyKcal100g,
                        protein = item.proteins100g,
                        fat = item.fat100g,
                        carbohydrates = item.carbohydrates100g,
                        brands = item.brands,
                        categories = item.categories
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