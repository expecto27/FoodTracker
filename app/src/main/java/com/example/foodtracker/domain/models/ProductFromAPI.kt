package com.example.foodtracker.domain.models

import com.google.gson.annotations.SerializedName

data class ProductFromAPI (
    @SerializedName("id") val id: Int,
    @SerializedName("product_name") val productName: String?,
    @SerializedName("quantity") val quantity: String?,
    @SerializedName("packaging") val packaging: String?,
    @SerializedName("brands") val brands: String?,
    @SerializedName("categories") val categories: String?,
    @SerializedName("stores") val stores: String?,
    @SerializedName("countries") val countries: String?,
    @SerializedName("serving_size") val servingSize: String?,
    @SerializedName("serving_quantity") val servingQuantity: String?,
    @SerializedName("nutriscore_score") val nutritionScoreScore: Int?,
    @SerializedName("nutriscore_grade") val nutritionScoreGrade: String?,
    @SerializedName("image_url") val imageUrl: String?,
    @SerializedName("image_small_url") val imageSmallUrl: String?,
    @SerializedName("energy-kj_100g") val energyKj100g: Float?,
    @SerializedName("energy-kcal_100g") val energyKcal100g: Float?,
    @SerializedName("energy_100g") val energy100g: Float?,
    @SerializedName("energy-from-fat_100g") val energyFromFat100g: Float?,
    @SerializedName("fat_100g") val fat100g: Float?,
    @SerializedName("saturated-fat_100g") val saturatedFat100g: Float?,
    @SerializedName("carbohydrates_100g") val carbohydrates100g: Float?,
    @SerializedName("proteins_100g") val proteins100g: Float?
)
