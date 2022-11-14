package com.fox.feature_cart_screen.data.models

import com.fox.feature_cart_screen.domain.models.BasketItem
import com.fox.feature_cart_screen.domain.models.CartProductItem
import com.google.gson.annotations.SerializedName

data class CartProductRemoteModel(
    @SerializedName("id") val id: Int,
    @SerializedName("basket") val basketItemList: List<BasketItemRemoteModel>,
    @SerializedName("delivery") val delivery: String,
    @SerializedName("total") val total: Int
) {
    fun toDomain(): CartProductItem {
        val basketItems = mutableListOf<BasketItem>()
        for(item in basketItemList)
            basketItems.add(item.toDomain())

        return CartProductItem(id, basketItems, delivery, total)
    }
}
