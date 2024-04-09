package com.example.foodtracker.presentation.ui.foodselect

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodtracker.databinding.FragmentFoodSelectBinding
import com.example.foodtracker.presentation.FragmentChanger
import com.example.foodtracker.presentation.ui.adapters.ProductAdapter
import com.example.foodtracker.presentation.ui.addproduct.AddProductFragment
import com.example.foodtracker.presentation.ui.models.Product
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodSelectFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = FoodSelectFragment()
    }

    private lateinit var binding: FragmentFoodSelectBinding
    private val viewModel: FoodSelectViewModel by viewModels()
    private lateinit var result: List<Product>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodSelectBinding.inflate(inflater, container, false)

        viewModel.searchData.observe(viewLifecycleOwner) { newData ->
            binding.foodSearch.text = Editable
                .Factory
                .getInstance()
                .newEditable(newData)
        }
        val eatingAdapter = ProductAdapter(context)

        viewModel.products.observe(viewLifecycleOwner){ newData ->
            newData.map {
                eatingAdapter.addCard(it)
            }
        }

        binding.rv.apply {
            adapter = eatingAdapter
            layoutManager = LinearLayoutManager(context)
        }
        binding.cancel.setOnClickListener {
            (activity as FragmentChanger).backInBackStack()
        }
        binding.addFood.setOnClickListener {
            (activity as FragmentChanger).changeMainFragment(AddProductFragment.newInstance())
        }
        binding.cancelSearch.setOnClickListener{
            eatingAdapter.clear()
            viewModel.setLivaDataText(binding.foodSearch.text.toString())
            viewModel.loadMyFood()
        }
        return binding.root
    }


    override fun onDestroy() {
        viewModel.setLivaDataText(binding.foodSearch.text.toString())
        super.onDestroy()
    }
}