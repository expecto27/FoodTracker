package com.example.foodtracker.presentation.ui.imtstat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.foodtracker.databinding.FragmentImtBinding
import com.example.foodtracker.domain.models.Target
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

        binding.buttonSubmit.setOnClickListener {
            val weight = binding.weight.text.toString().toDouble()
            val height = binding.height.text.toString().toDouble()
            val target = if(binding.radioButtonGrowWeight.isChecked){
                Target.Grow
            } else if(binding.radioButtonStayWeight.isChecked){
                Target.Stay
            } else{
                Target.Lose
            }
            viewModel.saveData(
                _weight = weight,
                _height = height,
                _name = binding.name.text.toString(),
                _age = binding.age.text.toString().toInt(),
                _gender = binding.radioButtonMale.isChecked,
                _target = target
            )
            val text = viewModel.getSnackBarVerdict(requireContext(), weight, height)
            Snackbar.make(binding.root, text, Snackbar.LENGTH_LONG).show()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}