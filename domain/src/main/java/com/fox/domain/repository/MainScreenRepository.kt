package com.fox.domain.repository

import com.fox.domain.models.PhoneListItem

interface MainScreenRepository {
    suspend fun getHotSaleItems(): PhoneListItem
}