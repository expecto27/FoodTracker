package com.example.foodtracker.presentation.ui.fragments.myproducts

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodtracker.data.models.Product
import com.example.foodtracker.domain.repository.ProductRepository
import com.example.foodtracker.presentation.ui.adapters.MyProductAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyProductViewModel @Inject constructor(
    private var savedStateHandle: SavedStateHandle,
    private var productRepository: ProductRepository
) : ViewModel() {
    fun initAdapterList(adapter: MyProductAdapter) {
        val data = viewModelScope.async(Dispatchers.IO) {
            return@async productRepository.getAll()
        }
        viewModelScope.launch {
            for (item in data.await()) {
                adapter.addCard(
                    com.example.foodtracker.presentation.ui.models.Product(
                        id = item.id,
                        name = item.name,
                        image_url = null,
                        image_small_url = null,
                        calories = item.calories,
                        protein = item.protein,
                        fat = item.fat,
                        carbohydrates = item.carbohydrates,
                        categories = null,
                        brands = null
                    )
                )
            }
        }
    }
}