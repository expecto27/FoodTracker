package com.example.foodtracker.presentation.ui.foodselect

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.foodtracker.databinding.FragmentFoodSelectBinding

class FoodSelectFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = FoodSelectFragment()
    }

    private lateinit var binding: FragmentFoodSelectBinding
    private val viewModel: FoodSelectViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodSelectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.searchData.observe(viewLifecycleOwner) { newData ->
            binding.foodSearch.text = Editable
                .Factory
                .getInstance()
                .newEditable(newData)
        }
    }

    override fun onDestroy() {
        viewModel.setLivaDataText(binding.foodSearch.text.toString())
        super.onDestroy()
    }
}