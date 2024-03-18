package com.example.foodtracker.presentation.ui.imtstat

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.foodtracker.databinding.FragmentImtBinding
import com.google.android.material.snackbar.Snackbar

class ImtStatFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = ImtStatFragment()
    }

    private lateinit var binding: FragmentImtBinding
    private val viewModel: ImtViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentImtBinding.inflate(inflater, container, false)

        binding.calculate.setOnClickListener {
            val weight = binding.imtEditWeight.text.toString().toDouble()
            val height = binding.imtEditHeight.text.toString().toDouble()
            val text = viewModel.getSnackBarVerdict(requireContext(), weight, height)
            Snackbar.make(binding.root, text, Snackbar.LENGTH_LONG).show()
        }

        return binding.root
    }
}