package com.example.foodtracker.presentation.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.foodtracker.databinding.FragmentProductBinding
import com.example.foodtracker.presentation.FragmentChanger
import com.example.foodtracker.presentation.ImageLoader
import com.example.foodtracker.presentation.ui.SharedViewModel
import com.example.foodtracker.presentation.ui.models.Product
import com.example.foodtracker.presentation.ui.navigation.NavigationManager
import kotlinx.coroutines.launch

class ProductFragment(private val item: Product) : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(item: Product) = ProductFragment(item)
    }

    private val viewModel: ProductViewModel by viewModels()
    private lateinit var binding: FragmentProductBinding
    private val sharedViewModel : SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductBinding.inflate(inflater, container, false)

        with(binding){
            titleEat.text = item.name ?: ""
            proteinsValue.text = if(item.protein == null) "0" else item.protein.toString()
            fatsValue.text = if(item.fat == null) "0" else item.fat.toString()
            carbohydratesValue.text = if(item.carbohydrates == null) "0" else item.categories.toString()
            brands.text = item.brands ?: ""
            categories.text = item.categories ?: ""
        }

        ImageLoader().loadImage(context, item.image_url, binding.imageView)

        binding.cancel.setOnClickListener {
            (activity as FragmentChanger).backInBackStack()
        }

        binding.add.setOnClickListener {

        }

        return binding.root
    }
}