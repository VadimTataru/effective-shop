package com.fox.domain.interactor

import com.fox.domain.models.PhoneListItem
import com.fox.domain.repository.MainScreenRepository
import javax.inject.Inject

class MainScreenInteractor @Inject constructor(
    private val mainScreenRepository: MainScreenRepository
) {
    suspend fun getHotSaleItems(): PhoneListItem {
        return mainScreenRepository.getHotSaleItems()
    }
}