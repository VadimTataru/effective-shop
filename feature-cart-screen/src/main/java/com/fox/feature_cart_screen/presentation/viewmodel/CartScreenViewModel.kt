package com.fox.feature_cart_screen.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fox.feature_cart_screen.domain.interactor.CartScreenInteractor
import com.fox.feature_cart_screen.domain.models.BasketItem
import com.fox.feature_cart_screen.domain.models.CartProductItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class CartScreenViewModel @Inject constructor(
    private val interactor: CartScreenInteractor
): ViewModel() {

    private var cartProduct: MutableLiveData<CartProductItem> = MutableLiveData()
    private var basketItems: MutableLiveData<MutableList<BasketItem>> = MutableLiveData()

    fun getCartProductInfo(): MutableLiveData<CartProductItem> = cartProduct
    fun getBasketItems(): MutableLiveData<MutableList<BasketItem>> = basketItems

    fun getData() {
        viewModelScope.launch {
            val result = interactor.getCartProduct()
            cartProduct.value = result
            basketItems.value = result.basketItemList.toMutableList()
        }
    }

    fun deleteProduct(id: Int) {
        for(item in basketItems.value!!) {
            if (item.id == id)
                basketItems.value!!.remove(item)
        }
    }
}