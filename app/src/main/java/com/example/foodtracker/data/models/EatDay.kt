package com.example.foodtracker.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.foodtracker.domain.models.Meal
import java.util.Date

@Entity(tableName = "eat_day")
data class EatDay(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo("server_id")
    val serverId: Int?,
    @ColumnInfo("local_id")
    val localId: Int?,
    @ColumnInfo("day")
    val day: Date,
    @ColumnInfo("meal")
    val meal: Int
)
