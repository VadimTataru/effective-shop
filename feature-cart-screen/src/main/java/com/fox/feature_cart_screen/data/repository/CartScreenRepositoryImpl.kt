package com.fox.feature_cart_screen.data.repository

import com.fox.feature_cart_screen.data.source.remote.CartScreenService
import com.fox.feature_cart_screen.domain.models.CartProductItem
import com.fox.feature_cart_screen.domain.repository.CartScreenRepository
import javax.inject.Inject

class CartScreenRepositoryImpl @Inject constructor(
    private val service: CartScreenService
): CartScreenRepository {

    override suspend fun getCartProducts(): CartProductItem {
        val response = service.getCartProduct()
        var result: CartProductItem? = null
        if(response.isSuccessful)
            result = response.body()!!.toDomain()
        return result!!
    }
}