package com.fox.feature_main_screen.domain.models

data class PhoneListItem(
    val hotSales: List<HotSaleItem>,
    val bestSellers: List<BestSellerItem>
)