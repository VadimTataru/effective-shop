package com.fox.domain.interactor

import com.fox.domain.models.HotSaleItem
import com.fox.domain.repository.MainScreenRepository
import javax.inject.Inject

class MainScreenInteractor @Inject constructor(
    private val mainScreenRepository: MainScreenRepository
) {
    suspend fun getHotSaleItems(): List<HotSaleItem> {
        return mainScreenRepository.getHotSaleItems()
    }
}