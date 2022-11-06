package com.fox.data.models

import com.google.gson.annotations.SerializedName

data class BestSellerRemoteModel(
    @SerializedName("id") val id: Int,
    @SerializedName("is_favorites") val isFavorites: Boolean,
    @SerializedName("title") val title: String,
    @SerializedName("price_without_discount") val priceWithDiscount: Int,
    @SerializedName("discount_price") val priceWithoutDiscount: Int,
    @SerializedName("picture") val pictureUri: String
)
