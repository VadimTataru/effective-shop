package com.fox.feature_main_screen.domain.models

data class BestSellerItem(
    val id: Int,
    val isFavourite: Boolean,
    val title: String,
    val priceWithDiscount: Int,
    val priceWithoutDiscount: Int,
    val pictureUri: String
)
