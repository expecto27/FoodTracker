package com.example.foodtracker.presentation.ui.fragments.main

import android.content.Context
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
import com.example.foodtracker.R
import com.example.foodtracker.data.repository.ProductApiRepositoryImpl
import com.example.foodtracker.databinding.FragmentMainBinding
import com.example.foodtracker.domain.models.Meal
import com.example.foodtracker.domain.usecase.GetUserData
import com.example.foodtracker.presentation.FragmentChanger
import com.example.foodtracker.presentation.ImageLoader
import com.example.foodtracker.presentation.mapper.IntToMeal
import com.example.foodtracker.presentation.ui.SharedViewModel
import com.example.foodtracker.presentation.ui.adapters.EatingAdapter
import com.example.foodtracker.presentation.ui.fragments.foodselect.FoodSelectFragment
import com.example.foodtracker.presentation.ui.models.DailyStat
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

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
        val adapter1: EatingAdapter =
            EatingAdapter(ProductApiRepositoryImpl(), imageLoader = ImageLoader(requireContext()))
        val adapter2: EatingAdapter =
            EatingAdapter(ProductApiRepositoryImpl(), imageLoader = ImageLoader(requireContext()))
        val adapter3: EatingAdapter =
            EatingAdapter(ProductApiRepositoryImpl(), imageLoader = ImageLoader(requireContext()))
        val adapter4: EatingAdapter =
            EatingAdapter(ProductApiRepositoryImpl(), imageLoader = ImageLoader(requireContext()))

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
            s.map {
                when (IntToMeal.map(it.meal)) {
                    Meal.Breakfast -> adapter1.addCard(it)
                    Meal.Lunch -> adapter2.addCard(it)
                    Meal.Dinner -> adapter3.addCard(it)
                    Meal.Other -> adapter4.addCard(it)
                }
            }
            val data = mutableListOf(
                adapter1.calculateTotal(),
                adapter2.calculateTotal(),
                adapter3.calculateTotal(),
                adapter4.calculateTotal()
            )
            val dailyAllTotal = calculateAllDay(data)
            binding.energyValue.text = dailyAllTotal.calories.roundToInt().toString()
            binding.target.text = viewModel.getTarget().dailyCalories.roundToInt().toString()
            binding.statText.text = getString(R.string.today).plus(" ${viewModel.getUserName()}")
        }

    }


    fun calculateAllDay(data: List<DailyStat>): DailyStat {
        var calories = 0.0
        var proteins = 0.0
        var fats = 0.0
        var carbohydrates = 0.0
        data.map {
            Log.d("AdapterAnswer", it.calories.toString())
            calories += it.calories
            fats += it.fats
            proteins += it.protein
            carbohydrates += it.carbohydrates
        }
        return DailyStat(calories, proteins, fats, carbohydrates)
    }
}