package com.example.foodtracker.presentation.ui.fragments.foodselect

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodtracker.domain.usecase.SearchMyProducts
import com.example.foodtracker.domain.usecase.SearchProducts
import com.example.foodtracker.presentation.ui.models.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodSelectViewModel @Inject constructor(
    private var savedStateHandle: SavedStateHandle,
    private var searchProducts: SearchProducts,
    private var searchMyProducts: SearchMyProducts
) : ViewModel() {

    private val _searchData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }


    val searchData: LiveData<String>
        get() = _searchData

    private val _products: MutableLiveData<MutableList<Product>> by lazy {
        MutableLiveData()
    }
    private val productList: MutableList<Product> by lazy {
        mutableListOf<Product>()
    }
    val products: LiveData<MutableList<Product>>
        get() = _products


    fun setLivaDataText(value: String) {
        _searchData.value = value
    }

    fun search() {
        updateProductsData()
        loadMyProducts()
        loadProducts()
    }

    private fun updateProductsData() {
        _products.value = mutableListOf<Product>()

    }

    private fun addToLiveData() {
        viewModelScope.launch(Dispatchers.Main) { _products.value = productList }
    }

    private fun loadMyProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            searchMyProducts.execute(_searchData.value ?: "").map { item ->
                productList.add(
                    Product(
                        id = item.id,
                        name = item.name,
                        image_url = null,
                        image_small_url = null,
                        calories = item.calories,
                        protein = item.protein,
                        fat = item.fat,
                        carbohydrates = item.carbohydrates,
                        brands = null,
                        categories = null
                    )
                )
            }
            addToLiveData()
        }
    }


    private fun loadProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            searchProducts.execute(_searchData.value)?.map { item ->
                Log.d(this.javaClass.name, item.productName ?: "")
                productList.add(
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
                )
            }
            addToLiveData()
        }
    }
}