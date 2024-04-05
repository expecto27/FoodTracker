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
import com.example.foodtracker.presentation.FragmentChanger
import com.example.foodtracker.presentation.ui.adapters.EatingCardAdapter
import com.example.foodtracker.presentation.ui.foodselect.FoodSelectFragment
import com.example.foodtracker.presentation.ui.models.AdditionCard
import com.example.foodtracker.presentation.ui.models.EatingCard

class MainFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: FragmentMainBinding
    val viewModel: MainViewModel by viewModels()

    private fun EatingCardAdapter.initItems(){
        val changeListener = {
            (activity as FragmentChanger).changeMainFragment(FoodSelectFragment.newInstance())
        }

        val addListener = {
            this.addCustomCard(
                EatingCard(
                    R.drawable.fast_food,
                    R.color.black,
                    getString(R.string.fast_food),
                    changeListener
                )
            )
        }
        this.addCard(
            EatingCard(
                R.drawable.breakfast,
                R.color.purple_500,
                getString(R.string.breakfast),
                changeListener
            )
        )
        this.addCard(
            EatingCard(
                R.drawable.lunchmain,
                R.color.purple_500,
                getString(R.string.lunch) ,
                changeListener
            )
        )
        this.addCard(
            EatingCard(
                R.drawable.lunch,
                R.color.purple_500,
                getString(R.string.dinner),
                changeListener
            )
        )

        this.addCard(
            AdditionCard(
                R.drawable.plus,
                R.color.green,
                getString(R.string.add),
                addListener
            )
        )
    }
    private fun initRecyclerView() {

        val _adapter = EatingCardAdapter()

        binding.rvMain.apply {
            adapter = _adapter
            layoutManager = LinearLayoutManager(this@MainFragment.context)
        }
        if(_adapter.itemCount == 0){
            _adapter.initItems()
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            initRecyclerView()
    }

}