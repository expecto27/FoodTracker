package com.example.foodtracker.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "calories")
    val calories: Float,
    @ColumnInfo(name = "protein")
    val protein: Float?,
    @ColumnInfo(name = "fat")
    val fat: Float?,
    @ColumnInfo(name = "carbohydrates")
    val carbohydrates: Float?
)

