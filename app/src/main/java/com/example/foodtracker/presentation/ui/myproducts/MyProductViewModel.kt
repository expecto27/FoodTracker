package com.example.foodtracker.presentation.ui.myproducts

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodtracker.domain.repository.ProductRepository
import com.example.foodtracker.presentation.ui.adapters.MyProductAdapter
import com.example.foodtracker.presentation.ui.models.Product
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyProductViewModel @Inject constructor(
    private var savedStateHandle: SavedStateHandle,
    private var productRepository: ProductRepository
) : ViewModel() {
    fun initAdapterList(adapter: MyProductAdapter) {
        viewModelScope.launch {
            val data = productRepository.getAll()
            for(item in data){
                adapter.addCard(Product(
                    item.name,
                    item.calories,
                    item.protein,
                    item.fat,
                    item.carbohydrates
                ))
            }
        }
    }
}