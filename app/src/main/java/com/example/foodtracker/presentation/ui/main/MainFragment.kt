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
import com.example.foodtracker.databinding.FragmentMainBinding
import com.example.foodtracker.domain.models.EatingDomain
import com.example.foodtracker.domain.models.Meal
import com.example.foodtracker.presentation.FragmentChanger
import com.example.foodtracker.presentation.ui.SharedViewModel
import com.example.foodtracker.presentation.ui.foodselect.FoodSelectFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val sharedViewModel : SharedViewModel by activityViewModels()


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

        lifecycleScope.launch {
            val res = viewModel.getAllEating()
            val s = res.await()
            Log.d("DataBaseAnswer", s.size.toString())

            for(i in s.indices){
                Log.d("DataBaseAnswer", s[i].id.toString())
                Log.d("DataBaseAnswer", s[i].weight.toString())
                Log.d("DataBaseAnswer", s[i].serverId.toString())
                Log.d("DataBaseAnswer", s[i].meal.toString())
            }
        }

    }
}