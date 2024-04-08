package com.example.foodtracker.presentation.ui.foodselect

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.foodtracker.domain.repository.ProductRepository
import com.example.foodtracker.domain.usecase.SearchProducts
import com.example.foodtracker.presentation.ui.models.Product
import dagger.hilt.android.lifecycle.HiltViewModel
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

    fun setLivaDataText(value: String) {
        _searchData.value = value
    }

    fun loadMyFood(): List<Product> {
        val resultFromAPI = searchProducts.execute(_searchData.value)
        val result: MutableList<Product> = emptyList<Product>().toMutableList()
        for (item in resultFromAPI) {
            result.add(
                Product(
                    name = item.productName,
                    calories = item.energyKcal100g,
                    protein = item.proteins100g,
                    fat = item.fat100g,
                    carbohydrates = item.carbohydrates100g
                )
            )
        }
        return result
    }

//    fun loadMyFood(){
//        viewModelScope.launch(Dispatchers.Default) {
//            val lst = productRepository.getAll()
//            for(item in lst){
//                Log.d("dsds", item.toString())
//            }
//        }
//    }

}