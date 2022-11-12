package com.fox.feature_details_screen.domain.repository

import com.fox.feature_details_screen.domain.models.ProductDetailsItem

interface DetailsScreenRepository {
    suspend fun getProductDetails(): ProductDetailsItem
}