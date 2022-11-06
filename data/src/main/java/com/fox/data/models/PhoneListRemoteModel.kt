package com.fox.data.models

import com.google.gson.annotations.SerializedName

data class PhoneListRemoteModel(
    @SerializedName("home_store") val hotSales: List<HotSalesRemoteModel>,
    @SerializedName("best_seller") val bestSellers: List<BestSellerRemoteModel>
)