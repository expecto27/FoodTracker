package com.example.foodtracker.presentation.ui.fragments.foodselect

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodtracker.databinding.FragmentFoodSelectBinding
import com.example.foodtracker.presentation.FragmentChanger
import com.example.foodtracker.presentation.ImageLoader
import com.example.foodtracker.presentation.ui.adapters.ProductAdapter
import com.example.foodtracker.presentation.ui.fragments.addproduct.AddProductFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext

@AndroidEntryPoint
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

        viewModel.searchData.observe(viewLifecycleOwner) { newData ->
            binding.foodSearch.text = Editable
                .Factory
                .getInstance()
                .newEditable(newData)
        }

        val productAdapter = ProductAdapter(activity as AppCompatActivity, imageLoader = ImageLoader(requireContext()))

        viewModel.products.observe(viewLifecycleOwner){ newData ->
            newData.map {
                productAdapter.addCard(it)
            }
        }

        binding.rv.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(context)
        }

        binding.cancel.setOnClickListener {
            (activity as FragmentChanger).backInBackStack()
        }
        binding.addFood.setOnClickListener {
            (activity as FragmentChanger).changeMainFragment(AddProductFragment.newInstance())
        }
        binding.cancelSearch.setOnClickListener{
            productAdapter.clear()
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