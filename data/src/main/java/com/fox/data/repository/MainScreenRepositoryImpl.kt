package com.fox.data.repository

import com.fox.data.source.remote.PhoneListService
import com.fox.domain.models.PhoneListItem
import com.fox.domain.repository.MainScreenRepository
import javax.inject.Inject

class MainScreenRepositoryImpl @Inject constructor(
    private val service: PhoneListService
): MainScreenRepository {

    override suspend fun getHotSaleItems(): PhoneListItem {
        val response = service.getPhoneList()
        var result: PhoneListItem? = null
        if (response.isSuccessful) {
                 result = response.body()!!.convertToDomain()
        }
        return result!!
    }
}