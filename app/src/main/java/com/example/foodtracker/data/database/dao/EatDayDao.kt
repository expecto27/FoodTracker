package com.example.foodtracker.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.foodtracker.data.models.EatDay
import com.example.foodtracker.data.models.Product

@Dao
interface EatDayDao {
    @Query("SELECT * FROM eat_day")
    fun getAll() : List<EatDay>


    @Query("SELECT * FROM eat_day WHERE strftime('%d', day) = strftime('%d', datetime('now'))")
    fun getWithCurrentDate(): List<EatDay>
    @Insert
    fun save(eatDay: EatDay)

    @Delete
    fun delete(eatDay: EatDay)
}