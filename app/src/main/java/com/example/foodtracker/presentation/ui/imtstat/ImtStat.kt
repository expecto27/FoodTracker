package com.example.foodtracker.presentation.ui.imtstat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodtracker.R
import com.example.foodtracker.databinding.FragmentImtBinding

class ImtStat : Fragment() {

    companion object{
        @JvmStatic
        fun newInstance() = ImtStat()
    }
    private lateinit var binding : FragmentImtBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflater.inflate(R.layout.fragment_imt, container, false)
        binding = FragmentImtBinding.inflate(inflater, container, false)



        return binding.root
    }
}