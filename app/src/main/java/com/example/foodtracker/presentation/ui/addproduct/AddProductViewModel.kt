package com.example.foodtracker.presentation.ui.addproduct

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodtracker.data.models.Product
import com.example.foodtracker.domain.models.MyProduct
import com.example.foodtracker.domain.repository.ProductRepository
import com.example.foodtracker.domain.usecase.SaveMyProduct
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddProductViewModel  @Inject constructor(
    private var savedStateHandle: SavedStateHandle,
    private var productRepository: ProductRepository
) : ViewModel() {
    fun saveProduct(_name: String, _calories: Float, _protein: Float?, _fat: Float?, _carbohydrates: Float?){

        val product =  MyProduct(
            id = 0,
            name = _name,
            calories = _calories,
            protein = _protein,
            fat = _fat,
            carbohydrates = _carbohydrates
        )
        viewModelScope.launch(Dispatchers.Default) {
            SaveMyProduct(productRepository).execute(product)
        }
    }
}