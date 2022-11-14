package com.fox.feature_cart_screen.domain.repository

import com.fox.feature_cart_screen.domain.models.CartProductItem

interface CartScreenRepository {
    suspend fun getCartProducts(): CartProductItem
}