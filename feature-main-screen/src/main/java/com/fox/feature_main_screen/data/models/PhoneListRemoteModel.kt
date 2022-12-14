package com.fox.feature_main_screen.data.models

import com.fox.feature_main_screen.domain.models.BestSellerItem
import com.fox.feature_main_screen.domain.models.HotSaleItem
import com.fox.feature_main_screen.domain.models.PhoneListItem
import com.google.gson.annotations.SerializedName

data class PhoneListRemoteModel(
    @SerializedName("home_store") val hotSales: List<HotSalesRemoteModel>,
    @SerializedName("best_seller") val bestSellers: List<BestSellerRemoteModel>
) {
    fun convertToDomain(): PhoneListItem {
        val hotSalesDomain = mutableListOf<HotSaleItem>()
        for(item in hotSales) {
            hotSalesDomain.add(item.convertToDomain())
        }
        val bestSellerDomain = mutableListOf<BestSellerItem>()
        for(item in bestSellers) {
            bestSellerDomain.add(item.convertToDomain())
        }

        return PhoneListItem(
            hotSalesDomain,
            bestSellerDomain
        )
    }
}