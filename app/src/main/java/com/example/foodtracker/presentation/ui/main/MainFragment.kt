package com.example.foodtracker.presentation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodtracker.R
import com.example.foodtracker.databinding.FragmentMainBinding
import com.example.foodtracker.presentation.ui.adapters.EatingCardAdapter
import com.example.foodtracker.presentation.ui.models.EatingCard

class MainFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: FragmentMainBinding
    val viewModel: MainViewModel by viewModels()
    private val _adapter = EatingCardAdapter()

    private fun initRecyclerView(){
        binding.rvMain.apply {
            adapter = _adapter
            layoutManager = LinearLayoutManager(this@MainFragment.context)


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMainBinding.inflate(inflater, container, false)
        initRecyclerView()
        for(i in 1..10){
            _adapter.addCard(
                EatingCard(
                    imageId = R.drawable.example,
                    color = R.color.purple_700,
                    "hello"
                )
            )
        }

        return binding.root
    }

}