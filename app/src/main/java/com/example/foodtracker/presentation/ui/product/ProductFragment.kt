package com.example.foodtracker.presentation.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.foodtracker.databinding.FragmentProductBinding
import com.example.foodtracker.presentation.ui.models.Product

class ProductFragment(private val item: Product) : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(item: Product) = ProductFragment(item)
    }

    private val viewModel: ProductViewModel by viewModels()
    private lateinit var binding: FragmentProductBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductBinding.inflate(inflater)
        return binding.root
    }


}