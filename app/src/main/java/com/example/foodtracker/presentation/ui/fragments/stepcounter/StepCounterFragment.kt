package com.example.foodtracker.presentation.ui.fragments.stepcounter

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.foodtracker.App
import com.example.foodtracker.R
import com.example.foodtracker.databinding.FragmentStepCounterBinding

class StepCounterFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = StepCounterFragment()
    }

    private val viewModel: StepCounterViewModel by viewModels {
        StepCounterViewModelFactory(requireActivity().application)
    }
    private lateinit var binding: FragmentStepCounterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStepCounterBinding.inflate(inflater, container, false)
        viewModel.stepCount.observe(viewLifecycleOwner, Observer {
            if (it == -1) {
                binding.stepsCount.text = getString(R.string.step_sensor_error)
            } else {
                binding.stepsCount.text = it.toString()
            }
        })
        return binding.root
    }
}