package com.example.foodtracker.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.foodtracker.data.models.EatDay
import com.example.foodtracker.data.models.Product

@Dao
interface EatDayDao {
    @Query("SELECT * FROM eat_day")
    fun getAll() : List<EatDay>
    @Insert
    fun save(eatDay: EatDay)
}