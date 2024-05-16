package com.example.foodtracker.presentation.ui.imtstat

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.foodtracker.R
import com.example.foodtracker.domain.models.Height
import com.example.foodtracker.domain.models.ImtVerdict
import com.example.foodtracker.domain.models.IndexIMT
import com.example.foodtracker.domain.models.Target
import com.example.foodtracker.domain.models.UserData
import com.example.foodtracker.domain.models.Weight
import com.example.foodtracker.domain.usecase.CalculateIMT
import com.example.foodtracker.domain.usecase.GetImtVerdict
import com.example.foodtracker.domain.usecase.GetUserData
import com.example.foodtracker.domain.usecase.SaveUserData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel

class ImtViewModel @Inject constructor(
    private var savedStateHandle: SavedStateHandle,
    private var calculateIMT: CalculateIMT,
    private var getImtVerdict: GetImtVerdict,
    private var saveUserData: SaveUserData,
    private var getUserData: GetUserData,
) : ViewModel() {
    fun getSnackBarVerdict(context: Context, weight: Double, height: Double): String {

        val imt: IndexIMT = calculateIMT.execute(Weight(weight), Height(height))

        val resId: Int = when (getImtVerdict.execute(imt)) {
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

    fun saveData(
        _name: String,
        _age: Int,
        _height: Double,
        _weight: Double,
        _target: Target,
        _gender: Boolean
    ) {
        saveUserData.execute(
            UserData(
                name = _name,
                age = _age,
                height = Height(_height),
                weight = Weight(_weight),
                target = _target,
                gender = _gender
            )
        )
    }
}