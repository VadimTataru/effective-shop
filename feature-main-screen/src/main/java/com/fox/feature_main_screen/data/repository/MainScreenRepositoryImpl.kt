package com.fox.feature_main_screen.data.repository

import com.fox.feature_main_screen.data.source.remote.MainScreenService
import com.fox.feature_main_screen.domain.models.PhoneListItem
import com.fox.feature_main_screen.domain.repository.MainScreenRepository
import javax.inject.Inject


class MainScreenRepositoryImpl @Inject constructor(
    private val service: MainScreenService
): MainScreenRepository {

    override suspend fun getHotSaleItems(): PhoneListItem {
        val response = service.getPhoneList()
        var result: PhoneListItem? = null
        if (response.isSuccessful) {
                 result = response.body()!!.convertToDomain()
        }
        return result!!
    }

    override suspend fun getCartItemsCount(): Int {
        val response = service.getCartItemCount()
        var result = 0;
        if(response.isSuccessful)
            result = response.body()!!.basket.size
        return result
    }
}
