package com.example.foodtracker.presentation.ui.imtstat

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.foodtracker.R
import com.example.foodtracker.domain.models.Height
import com.example.foodtracker.domain.models.ImtVerdict
import com.example.foodtracker.domain.models.IndexIMT
import com.example.foodtracker.domain.models.Weight
import com.example.foodtracker.domain.usecase.CalculateIMT
import com.example.foodtracker.domain.usecase.GetImtVerdict

class ImtViewModel : ViewModel() {
    fun getSnackBarVerdict(context: Context, weight: Double, height: Double): String {

        val imt: IndexIMT = CalculateIMT.execute(Weight(weight), Height(height))

        val resId: Int = when (GetImtVerdict.execute(imt)) {
            ImtVerdict.SevereBodyWeightDeficiency -> R.string.severe_body_weight_deficiency
            ImtVerdict.InsufficientBodyWeight -> R.string.insufficient_body_weight
            ImtVerdict.Standard -> R.string.standard
            ImtVerdict.Overweight -> R.string.overweight
            ImtVerdict.FirstDegreeObesity -> R.string.first_degree_obesity
            ImtVerdict.SecondDegreeObesity -> R.string.second_degree_obesity
            ImtVerdict.ThirdDegreeObesity -> R.string.third_degree_obesity
            else -> {
                R.string.unknown_verdict
            }
        }

        return "Ваш ИМТ: ${imt.value} " + context.getString(resId)
    }
}