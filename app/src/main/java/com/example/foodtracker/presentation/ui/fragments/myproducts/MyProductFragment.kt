package com.example.foodtracker.presentation.ui.fragments.myproducts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodtracker.databinding.FragmentAddProductBinding
import com.example.foodtracker.databinding.FragmentMyProductBinding
import com.example.foodtracker.databinding.MyProdCardBinding
import com.example.foodtracker.presentation.ui.adapters.MyProductAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyProductFragment : Fragment() {

    companion object {
        fun newInstance() = MyProductFragment()
    }

    val viewModel: MyProductViewModel by viewModels()
    private lateinit var binding: FragmentMyProductBinding
    fun initRecyclerView() {
        val _adapter = MyProductAdapter()
        binding.rvMain.apply {
            adapter = _adapter
            layoutManager = LinearLayoutManager(this@MyProductFragment.context)
        }
        viewModel.initAdapterList(_adapter)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyProductBinding.inflate(layoutInflater)
        initRecyclerView()
        return binding.root
    }


}