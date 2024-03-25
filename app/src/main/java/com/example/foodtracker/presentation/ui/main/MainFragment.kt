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
import com.example.foodtracker.presentation.ui.models.AdditionCard
import com.example.foodtracker.presentation.ui.models.EatingCard

class MainFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: FragmentMainBinding
    val viewModel: MainViewModel by viewModels()
    private val _adapter = EatingCardAdapter()

    private fun initRecyclerView() {
        binding.rvMain.apply {
            adapter = _adapter
            layoutManager = LinearLayoutManager(this@MainFragment.context)
        }



        _adapter.addCard(
            EatingCard(
                R.drawable.breakfast,
                R.color.purple_200,
                getString(R.string.breakfast)
            )
        )
        _adapter.addCard(
            EatingCard(
                R.drawable.lunchmain,
                R.color.purple_500,
                getString(R.string.lunch)
            )
        )
        _adapter.addCard(
            EatingCard(
                R.drawable.lunch,
                R.color.purple_700,
                getString(R.string.dinner)
            )
        )
        val listener = {
            _adapter.addCustomCard(
                EatingCard(
                    R.drawable.fast_food,
                    R.color.black,
                    getString(R.string.fast_food)
                )
            )
        }

        _adapter.addCard(
            AdditionCard(
                R.drawable.plus,
                R.color.green,
                "Добавить",
                listener,
                false
            )
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMainBinding.inflate(inflater, container, false)
        initRecyclerView()

        return binding.root
    }

}