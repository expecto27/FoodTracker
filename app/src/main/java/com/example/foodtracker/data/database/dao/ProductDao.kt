package com.example.foodtracker.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.foodtracker.data.models.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM products")
    fun getAll() : List<Product>

    @Query("SELECT * FROM products WHERE name Like :name")
    fun findByName(name: String) : List<Product>

    @Insert
    fun save(product: Product)

    @Delete
    fun delete(product: Product)
}
