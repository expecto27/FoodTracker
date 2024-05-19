package com.example.foodtracker.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
@Entity("drink")
data class DrinkStat (
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo("ml")
    val ml : Int,
    @ColumnInfo("day")
    val day : Date
)