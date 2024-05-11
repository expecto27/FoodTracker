package com.example.foodtracker.presentation.ui.addproduct

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.foodtracker.databinding.FragmentAddProductBinding
import com.example.foodtracker.presentation.FragmentChanger
import com.example.foodtracker.presentation.ui.models.Product
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddProductFragment  : Fragment() {
    private lateinit var binding: FragmentAddProductBinding
    private val viewModel: AddProductViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddProductBinding.inflate(layoutInflater)
        binding.cancel.setOnClickListener {
            (activity as FragmentChanger).backInBackStack()
        }
        binding.add.setOnClickListener {
            val name = binding.titleProduct.text.toString()
            val calories = binding.calories.text.toString().toFloat()
            val fat = binding.fat.text.toString().toFloat()
            val protein = binding.protein.text.toString().toFloat()
            val carb = binding.carbohydrates.text.toString().toFloat()

            viewModel.saveProduct(name, calories, protein, fat, carb)
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = AddProductFragment()
    }
}