package com.example.foodtracker.presentation.ui.fragments.drink

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.foodtracker.R
import com.example.foodtracker.databinding.FragmentDrinkBinding

class DrinkFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = DrinkFragment()
    }

    private val viewModel: DrinkViewModel by viewModels()
    private lateinit var binding: FragmentDrinkBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDrinkBinding.inflate(inflater)
        return binding.root
    }


}