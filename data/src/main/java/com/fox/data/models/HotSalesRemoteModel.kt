package com.fox.data.models

import com.fox.domain.models.HotSaleItem
import com.google.gson.annotations.SerializedName

data class HotSalesRemoteModel(
    @SerializedName("id") val id: Int,
    @SerializedName("is_new") val isNew: Boolean,
    @SerializedName("title") val title: String,
    @SerializedName("subtitle") val subtitle: String,
    @SerializedName("picture") val pictureUri: String,
    @SerializedName("is_buy") val isBuy: Boolean
) {
    fun convertToDomain(): HotSaleItem {
        return HotSaleItem(
            id,
            isNew,
            title,
            subtitle,
            pictureUri,
            isBuy
        )
    }
}