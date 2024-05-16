package com.example.foodtracker.presentation.ui.fragments.stepcounter

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodtracker.R

class StepCounterFragment : Fragment() {

    companion object {
        fun newInstance() = StepCounterFragment()
    }

    private lateinit var viewModel: StepCounterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_step_counter, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(StepCounterViewModel::class.java)
        // TODO: Use the ViewModel
    }

}