package com.fox.feature_details_screen.domain.models

data class ProductDetailsItem(
    val cpu: String,
    val camera: String,
    val capacity: List<String>,
    val color: List<String>,
    val id: String,
    val images: List<String>,
    var isFavorites: Boolean,
    val price: Int,
    val rating: Float,
    val sd: String,
    val ssd: String,
    val title: String
)