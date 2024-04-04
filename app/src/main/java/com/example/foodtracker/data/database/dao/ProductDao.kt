package com.example.foodtracker.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.foodtracker.data.models.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM product")
    fun getAll() : List<Product>

    @Query("SELECT * FROM product WHERE name Like :name")
    fun findByName(name: String) : Product
    @Insert
    fun save(product: Product)
}
