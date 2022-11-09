package com.fox.data.source.remote

import com.fox.data.models.PhoneListRemoteModel
import com.fox.data.models.ProductDetailsRemoteModel
import retrofit2.Response
import retrofit2.http.GET

interface PhoneListService {
    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getPhoneList(): Response<PhoneListRemoteModel>

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getPhoneDetails(): Response<ProductDetailsRemoteModel>
}