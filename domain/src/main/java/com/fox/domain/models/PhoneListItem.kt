package com.fox.domain.models

data class PhoneListItem(
    val hotSales: List<HotSaleItem>,
    val bestSellers: List<BestSellerItem>
)