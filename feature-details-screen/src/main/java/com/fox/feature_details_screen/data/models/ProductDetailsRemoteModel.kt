package com.fox.feature_details_screen.data.models

import com.fox.feature_details_screen.domain.models.ProductDetailsItem
import com.google.gson.annotations.SerializedName

data class ProductDetailsRemoteModel(
    @SerializedName("CPU") val cpu: String,
    @SerializedName("camera") val camera: String,
    @SerializedName("capacity") val capacity: List<String>,
    @SerializedName("color") val color: List<String>,
    @SerializedName("id") val id: String,
    @SerializedName("images") val images: List<String>,
    @SerializedName("isFavorites") var isFavorites: Boolean,
    @SerializedName("price") val price: Int,
    @SerializedName("rating") val rating: Float,
    @SerializedName("sd") val sd: String,
    @SerializedName("ssd") val ssd: String,
    @SerializedName("title") val title: String
) {
    fun convertToDomain(): ProductDetailsItem {
        return ProductDetailsItem(cpu, camera, capacity, color, id, images, isFavorites, price, rating, sd, ssd, title)
    }
}