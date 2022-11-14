package com.fox.feature_details_screen.domain.interactor

import com.fox.feature_details_screen.domain.models.ProductDetailsItem
import com.fox.feature_details_screen.domain.repository.DetailsScreenRepository
import javax.inject.Inject

class DetailsScreenInteractor @Inject constructor(
    private val detailsScreenRepository: DetailsScreenRepository
) {
    suspend fun getProductDetails(): ProductDetailsItem {
        return detailsScreenRepository.getProductDetails()
    }
}