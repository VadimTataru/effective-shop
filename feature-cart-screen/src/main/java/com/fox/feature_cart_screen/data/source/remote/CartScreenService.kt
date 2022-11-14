package com.fox.feature_cart_screen.data.source.remote

import com.fox.feature_cart_screen.data.models.CartProductRemoteModel
import retrofit2.Response
import retrofit2.http.GET

interface CartScreenService {
    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getCartProduct(): Response<CartProductRemoteModel>
}