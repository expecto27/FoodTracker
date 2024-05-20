package com.example.foodtracker.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.foodtracker.data.models.DrinkStat
import com.example.foodtracker.data.models.EatDay

@Dao
interface DrinkStatDao {
    @Query("SELECT * FROM drink")
    fun getAll(): List<DrinkStat>
    @Query("DELETE FROM drink")
    fun delete()
    @Query("SELECT * FROM drink WHERE strftime('%d', day) = strftime('%d', datetime('now'))")
    fun getWithCurrentDate(): List<DrinkStat>

    @Insert
    fun save(eatDay: DrinkStat)
}