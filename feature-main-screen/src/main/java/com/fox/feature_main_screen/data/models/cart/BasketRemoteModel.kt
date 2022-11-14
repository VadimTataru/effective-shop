package com.fox.feature_main_screen.data.models.cart

import com.google.gson.annotations.SerializedName

data class BasketRemoteModel(
    @SerializedName("id") val id: Int,
    @SerializedName("images") val image: String,
    @SerializedName("price") val price: Int,
    @SerializedName("title") val title: String
)