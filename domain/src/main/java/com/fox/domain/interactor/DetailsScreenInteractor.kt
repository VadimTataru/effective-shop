package com.fox.domain.interactor

import com.fox.domain.models.ProductDetailsItem
import com.fox.domain.repository.DetailsScreenRepository
import javax.inject.Inject

class DetailsScreenInteractor @Inject constructor(
    private val detailsScreenRepository: DetailsScreenRepository
) {
    suspend fun getProductDetails(): ProductDetailsItem {
        return detailsScreenRepository.getProductDetails()
    }
}