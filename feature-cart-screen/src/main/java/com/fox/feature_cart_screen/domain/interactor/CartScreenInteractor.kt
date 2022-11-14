package com.fox.feature_cart_screen.domain.interactor

import com.fox.feature_cart_screen.domain.models.CartProductItem
import com.fox.feature_cart_screen.domain.repository.CartScreenRepository
import javax.inject.Inject

class CartScreenInteractor @Inject constructor(
    private val repository: CartScreenRepository
) {
    suspend fun getCartProduct(): CartProductItem {
        return repository.getCartProducts()
    }
}