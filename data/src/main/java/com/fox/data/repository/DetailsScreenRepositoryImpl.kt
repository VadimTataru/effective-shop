package com.fox.data.repository

import com.fox.data.source.remote.PhoneListService
import com.fox.domain.models.ProductDetailsItem
import com.fox.domain.repository.DetailsScreenRepository
import javax.inject.Inject

class DetailsScreenRepositoryImpl @Inject constructor(
    private val service: PhoneListService
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