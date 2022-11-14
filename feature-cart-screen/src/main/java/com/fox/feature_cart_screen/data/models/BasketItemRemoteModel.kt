package com.fox.feature_cart_screen.data.models

import com.fox.feature_cart_screen.domain.models.BasketItem
import com.google.gson.annotations.SerializedName

data class BasketItemRemoteModel(
    @SerializedName("id") val id: Int,
    @SerializedName("images") val image: String,
    @SerializedName("price") val price: Int,
    @SerializedName("title") val title: String
) {
    fun toDomain(): BasketItem {
        return BasketItem(id, image, price, title)
    }
}
