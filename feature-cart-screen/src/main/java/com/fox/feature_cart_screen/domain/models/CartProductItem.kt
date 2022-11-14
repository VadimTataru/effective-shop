package com.fox.feature_cart_screen.domain.models

data class CartProductItem(
    val id: Int,
    val basketItemList: List<BasketItem>,
    val delivery: String,
    val total: Int
)
