package com.example.foodtracker.domain.usecase

import com.example.foodtracker.domain.models.UserData
import com.example.foodtracker.domain.repository.UserDataRepository

class GetUserData(private val userDataRepository: UserDataRepository) {
    fun execute(): UserData{
        return userDataRepository.getUserData()
    }
}