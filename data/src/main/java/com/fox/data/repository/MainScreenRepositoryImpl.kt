package com.fox.data.repository

import com.fox.data.source.remote.PhoneListService
import com.fox.domain.models.HotSaleItem
import com.fox.domain.repository.MainScreenRepository
import javax.inject.Inject

class MainScreenRepositoryImpl @Inject constructor(
    private val service: PhoneListService
): MainScreenRepository {

    override suspend fun getHotSaleItems(): List<HotSaleItem> {
        val hotListItems = service.getPhoneList()
        TODO("Not yet implemented")
    }
}