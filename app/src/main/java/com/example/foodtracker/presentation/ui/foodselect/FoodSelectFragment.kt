package com.example.foodtracker.presentation.ui.foodselect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodtracker.databinding.FragmentFoodSelectBinding

class FoodSelectFragment: Fragment() {

    companion object{
        @JvmStatic
        fun newInstance() = FoodSelectFragment()
    }

    private lateinit var binding: FragmentFoodSelectBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFoodSelectBinding.inflate(inflater, container, false)

        return binding.root
    }
}