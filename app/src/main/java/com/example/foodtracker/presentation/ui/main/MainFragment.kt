package com.example.foodtracker.presentation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.foodtracker.R

//import com.example.foodtracker.presentation.R

class MainMenuFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = MainMenuFragment()
    }
    

    val viewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}