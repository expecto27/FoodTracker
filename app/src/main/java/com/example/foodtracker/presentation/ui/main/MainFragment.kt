package com.example.foodtracker.presentation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.foodtracker.databinding.FragmentMainBinding
import com.example.foodtracker.presentation.FragmentChanger
import com.example.foodtracker.presentation.ui.foodselect.FoodSelectFragment

class MainFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: FragmentMainBinding
    val viewModel: MainViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.foods1.setOnClickListener {
            (activity as FragmentChanger).changeMainFragment(FoodSelectFragment.newInstance())
        }
        binding.foods2.setOnClickListener {
            (activity as FragmentChanger).changeMainFragment(FoodSelectFragment.newInstance())
        }
        binding.foods3.setOnClickListener {
            (activity as FragmentChanger).changeMainFragment(FoodSelectFragment.newInstance())
        }
        binding.foods4.setOnClickListener {
            (activity as FragmentChanger).changeMainFragment(FoodSelectFragment.newInstance())
        }
    }
}