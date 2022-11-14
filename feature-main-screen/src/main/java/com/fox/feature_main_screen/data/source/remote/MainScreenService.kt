package com.fox.feature_main_screen.data.source.remote

import com.fox.feature_main_screen.data.models.PhoneListRemoteModel
import com.fox.feature_main_screen.data.models.cart.BasketRemoteModel
import com.fox.feature_main_screen.data.models.cart.CartProductRemoteModel
import retrofit2.Response
import retrofit2.http.GET

interface MainScreenService {
    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getPhoneList(): Response<PhoneListRemoteModel>

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getCartItemCount(): Response<CartProductRemoteModel>
}