package com.example.foodtracker.presentation.ui.fragments.drink

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.foodtracker.R
import com.example.foodtracker.databinding.FragmentDrinkBinding
import com.example.foodtracker.presentation.ui.adapters.CalendarAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

@AndroidEntryPoint
class DrinkFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = DrinkFragment()
    }

    private val viewModel: DrinkViewModel by viewModels()
    private lateinit var binding: FragmentDrinkBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDrinkBinding.inflate(inflater)
        binding.targetText.text = getString(R.string.today_target) + " ${
            viewModel.getTarget()
        } мл"
        binding.progress.max = viewModel.getTarget()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var onSelect: Int = 0
        binding.spinnerWaterAmount.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    onSelect = parent?.getItemAtPosition(position).toString().split(' ')[0].toInt()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    onSelect = 0
                }
            }
        viewModel.drinkStat.observe(viewLifecycleOwner) { newData ->
            binding.progress.progress = newData
        }

        binding.buttonSave.setOnClickListener {
            viewModel.getDrinkStat()
            binding.buttonSave.text = viewModel.drinkStat.value.toString()
            viewModel.saveDrink(onSelect, CalendarAdapter().getDate(Calendar.getInstance()))
            Log.d(this.javaClass.name, CalendarAdapter().getDate(Calendar.getInstance()).toString())
        }
        binding.delete.setOnClickListener {
            viewModel.deleteDrink()
            viewModel.getDrinkStat()
            binding.buttonSave.text = viewModel.drinkStat.value.toString()
            viewModel.saveDrink(onSelect, CalendarAdapter().getDate(Calendar.getInstance()))
            Log.d(this.javaClass.name, CalendarAdapter().getDate(Calendar.getInstance()).toString())
        }
    }
}