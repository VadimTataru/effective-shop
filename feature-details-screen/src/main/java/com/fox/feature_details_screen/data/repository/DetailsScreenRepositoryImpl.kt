package com.fox.feature_details_screen.data.repository

import com.fox.feature_details_screen.data.source.remote.DetailsScreenService
import com.fox.feature_details_screen.domain.models.ProductDetailsItem
import com.fox.feature_details_screen.domain.repository.DetailsScreenRepository
import javax.inject.Inject

class DetailsScreenRepositoryImpl @Inject constructor(
    private val service: DetailsScreenService
): DetailsScreenRepository {

    override suspend fun getProductDetails(): ProductDetailsItem {
        val response = service.getPhoneDetails()
        var result: ProductDetailsItem? = null
        if (response.isSuccessful) {
            result = response.body()!!.convertToDomain()
        }
        return result!!
    }
}