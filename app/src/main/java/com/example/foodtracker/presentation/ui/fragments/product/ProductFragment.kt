package com.example.foodtracker.presentation.ui.fragments.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.foodtracker.databinding.FragmentProductBinding
import com.example.foodtracker.domain.models.Meal
import com.example.foodtracker.presentation.FragmentChanger
import com.example.foodtracker.presentation.ImageLoader
import com.example.foodtracker.presentation.ui.SharedViewModel
import com.example.foodtracker.presentation.ui.fragments.main.MainFragment
import com.example.foodtracker.presentation.ui.models.Product
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment(
    private val item: Product
) : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(item: Product) = ProductFragment(item)
    }

    private val viewModel: ProductViewModel by viewModels()
    private lateinit var binding: FragmentProductBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductBinding.inflate(inflater, container, false)

        with(binding) {
            titleEat.text = item.name ?: ""
            proteinsValue.text = if (item.protein == null) "0" else item.protein.toString()
            fatsValue.text = if (item.fat == null) "0" else item.fat.toString()
            caloriesValue.text = if (item.calories == null) "0" else item.calories.toString()

            carbohydratesValue.text =
                if (item.carbohydrates == null) "0" else item.carbohydrates.toString()
            brands.text = item.brands ?: ""
            categories.text = item.categories ?: ""
        }

        ImageLoader(requireContext()).loadImage(item.image_url, binding.imageView)

        binding.cancel.setOnClickListener {
            (activity as FragmentChanger).backInBackStack()
        }

        binding.add.setOnClickListener {
            var weight : Int = 0
            if(!binding.weight.text.equals("")) {
                weight = Integer.parseInt(binding.weight.text.toString())
            }
            viewModel.saveEating(
                id = null,
                serverId = item.id,
                localId = null,
                meal = sharedViewModel.meal.value ?: Meal.Other,
                // TODO: Прикрутить бродкаст ресивер потом
                weight = weight
            )
            (activity as FragmentChanger).changeMainFragment(
                MainFragment.newInstance()
            )
        }

        return binding.root
    }
}