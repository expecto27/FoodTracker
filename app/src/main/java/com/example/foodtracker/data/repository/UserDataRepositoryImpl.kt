package com.example.foodtracker.data.repository

import android.content.Context
import com.example.foodtracker.data.mappers.TargetConverter
import com.example.foodtracker.domain.models.Height
import com.example.foodtracker.domain.models.UserData
import com.example.foodtracker.domain.models.Weight
import com.example.foodtracker.domain.repository.UserDataRepository

class UserDataRepositoryImpl (context: Context) : UserDataRepository {
    private val PREF_NAME = "user_data"
    private var sharedPreferences =  context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    override fun saveUserData(userData: UserData): Boolean {
        val sharedEditor = sharedPreferences.edit()
        with(sharedEditor){
            putString("name", userData.name)
            putInt("age", userData.age)
            putBoolean("gender", userData.gender)
            putInt("target", TargetConverter.toInt(userData.target))
            putFloat("height", userData.height.value.toFloat())
            putFloat("weight", userData.weight.value.toFloat())
        }
        sharedEditor.apply()
        return true
    }

    override fun getUserData(): UserData {
        val name = sharedPreferences.getString("name", "") ?: ""
        val gender = sharedPreferences.getBoolean("gender", false)
        val target = sharedPreferences.getInt("target",  2)
        val heightValue = sharedPreferences.getFloat("height", 0f)
        val weightValue = sharedPreferences.getFloat("weight", 0f)
        val age = sharedPreferences.getInt("age", 0)

        return UserData(
            name = name,
            gender = gender,
            target = TargetConverter.toTarget(target),
            height = Height(heightValue.toDouble()),
            weight = Weight(weightValue.toDouble()),
            age = age
        )
    }
}