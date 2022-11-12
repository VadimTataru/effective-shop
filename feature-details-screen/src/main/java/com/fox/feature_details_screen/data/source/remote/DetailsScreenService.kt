package com.fox.feature_details_screen.data.source.remote

import com.fox.feature_details_screen.data.models.ProductDetailsRemoteModel
import retrofit2.Response
import retrofit2.http.GET

interface DetailsScreenService {
    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getPhoneDetails(): Response<ProductDetailsRemoteModel>
}
