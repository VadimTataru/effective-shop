package com.fox.domain.models

data class BestSellerItem(
    val id: Int,
    val isFavourite: Boolean,
    val title: String,
    val priceWithDiscount: Int,
    val priceWithoutDiscount: Int,
    val pictureUri: String
)
