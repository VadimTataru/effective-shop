package com.fox.feature_main_screen.domain.repository

import com.fox.feature_main_screen.domain.models.PhoneListItem

interface MainScreenRepository {
    suspend fun getHotSaleItems(): PhoneListItem

    suspend fun getCartItemsCount(): Int
}