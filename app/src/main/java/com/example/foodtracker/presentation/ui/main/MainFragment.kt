package com.example.foodtracker.presentation.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodtracker.data.repository.ProductApiRepositoryImpl
import com.example.foodtracker.databinding.FragmentMainBinding
import com.example.foodtracker.domain.models.Meal
import com.example.foodtracker.presentation.FragmentChanger
import com.example.foodtracker.presentation.ImageLoader
import com.example.foodtracker.presentation.mapper.IntToMeal
import com.example.foodtracker.presentation.ui.SharedViewModel
import com.example.foodtracker.presentation.ui.adapters.EatingAdapter
import com.example.foodtracker.presentation.ui.foodselect.FoodSelectFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    private val adapter1: EatingAdapter = EatingAdapter(ProductApiRepositoryImpl(), imageLoader = ImageLoader(context))
    private val adapter2: EatingAdapter = EatingAdapter(ProductApiRepositoryImpl(), imageLoader = ImageLoader(context))
    private val adapter3: EatingAdapter = EatingAdapter(ProductApiRepositoryImpl(), imageLoader = ImageLoader(context))
    private val adapter4: EatingAdapter = EatingAdapter(ProductApiRepositoryImpl(), imageLoader = ImageLoader(context))

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        sharedViewModel.setMeal(null)
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.foods1.setOnClickListener {
            sharedViewModel.setMeal(Meal.Breakfast)
            (activity as FragmentChanger).changeMainFragment(FoodSelectFragment.newInstance())
        }
        binding.foods2.setOnClickListener {
            sharedViewModel.setMeal(Meal.Lunch)
            (activity as FragmentChanger).changeMainFragment(FoodSelectFragment.newInstance())
        }
        binding.foods3.setOnClickListener {
            sharedViewModel.setMeal(Meal.Dinner)
            (activity as FragmentChanger).changeMainFragment(FoodSelectFragment.newInstance())
        }
        binding.foods4.setOnClickListener {
            sharedViewModel.setMeal(Meal.Other)
            (activity as FragmentChanger).changeMainFragment(FoodSelectFragment.newInstance())
        }

        binding.rv1.apply {
            adapter = adapter1
            layoutManager = LinearLayoutManager(context)
        }
        binding.rv2.apply {
            adapter = adapter2
            layoutManager = LinearLayoutManager(context)
        }
        binding.rv3.apply {
            adapter = adapter3
            layoutManager = LinearLayoutManager(context)
        }
        binding.rv4.apply {
            adapter = adapter4
            layoutManager = LinearLayoutManager(context)
        }

        lifecycleScope.launch {
            val res = viewModel.getAllEating()
            val s = res.await()
            s.map{
                when(IntToMeal.map(it.meal)){
                    Meal.Breakfast -> adapter1.addCard(it)
                    Meal.Lunch -> adapter2.addCard(it)
                    Meal.Dinner -> adapter3.addCard(it)
                    Meal.Other -> adapter4.addCard(it)
                }
            }
        }

    }
}