package com.fox.feature_main_screen.data.models.cart

import com.google.gson.annotations.SerializedName

data class CartProductRemoteModel(
    @SerializedName("basket") val basket: List<BasketRemoteModel>
)
