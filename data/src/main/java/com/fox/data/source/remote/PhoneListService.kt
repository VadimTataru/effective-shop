package com.fox.data.source.remote

import com.fox.data.models.PhoneListRemoteModel
import retrofit2.Response
import retrofit2.http.GET

interface PhoneListService {
    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getPhoneList(): Response<PhoneListRemoteModel>
}