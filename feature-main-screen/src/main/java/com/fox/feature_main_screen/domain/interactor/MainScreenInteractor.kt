package com.fox.feature_main_screen.domain.interactor

import com.fox.feature_main_screen.domain.models.PhoneListItem
import com.fox.feature_main_screen.domain.repository.MainScreenRepository
import javax.inject.Inject


class MainScreenInteractor @Inject constructor(
    private val mainScreenRepository: MainScreenRepository
) {
    suspend fun getHotSaleItems(): PhoneListItem {
        return mainScreenRepository.getHotSaleItems()
    }

    suspend fun getCartItemsCount(): Int {
        return mainScreenRepository.getCartItemsCount()
    }
}
