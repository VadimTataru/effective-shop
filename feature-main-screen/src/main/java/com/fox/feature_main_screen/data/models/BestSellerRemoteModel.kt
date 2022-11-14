package com.fox.feature_main_screen.data.models

import com.fox.feature_main_screen.domain.models.BestSellerItem
import com.google.gson.annotations.SerializedName

data class BestSellerRemoteModel(
    @SerializedName("id") val id: Int,
    @SerializedName("is_favorites") val isFavorites: Boolean,
    @SerializedName("title") val title: String,
    @SerializedName("price_without_discount") val priceWithDiscount: Int,
    @SerializedName("discount_price") val priceWithoutDiscount: Int,
    @SerializedName("picture") val pictureUri: String
) {
    fun convertToDomain(): BestSellerItem {
        return BestSellerItem(
            id,
            isFavorites,
            title,
            priceWithDiscount,
            priceWithoutDiscount,
            pictureUri
        )
    }
}
