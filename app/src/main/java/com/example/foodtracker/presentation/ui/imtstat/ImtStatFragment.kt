package com.example.foodtracker.presentation.ui.imtstat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.foodtracker.databinding.FragmentImtBinding
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

        binding.calculate.setOnClickListener {
            val weight = binding.imtEditWeight.text.toString().toDouble()
            val height = binding.imtEditHeight.text.toString().toDouble()
            val text = viewModel.getSnackBarVerdict(requireContext(), weight, height)
            Snackbar.make(binding.root, text, Snackbar.LENGTH_LONG).show()
        }
        val ex : String = """
            ogorjeg
            egpergore
            ergergprgk
        """.trimIndent()

        var a = if(ex.equals("4")){
            4
        }else{
            5
        }

        a = when(ex){
            "4" -> 4
            else -> 5
        }

        example{
            5 * 5
        }

        return binding.root
    }

    fun example(l: (Int) -> Int){
        l;
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}