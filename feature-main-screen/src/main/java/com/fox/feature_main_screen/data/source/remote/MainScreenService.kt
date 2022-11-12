package com.fox.feature_main_screen.data.source.remote

import com.fox.feature_main_screen.data.models.PhoneListRemoteModel
import retrofit2.Response
import retrofit2.http.GET

interface MainScreenService {
    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getPhoneList(): Response<PhoneListRemoteModel>
}