package com.fox.domain.repository

import com.fox.domain.models.HotSaleItem

interface MainScreenRepository {
    suspend fun getHotSaleItems(): List<HotSaleItem>
}