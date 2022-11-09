package com.fox.domain.repository

import com.fox.domain.models.ProductDetailsItem

interface DetailsScreenRepository {
    suspend fun getProductDetails(): ProductDetailsItem
}