package com.fox.feature_main_screen.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fox.feature_main_screen.domain.interactor.MainScreenInteractor
import com.fox.feature_main_screen.domain.models.BestSellerItem
import com.fox.feature_main_screen.domain.models.HotSaleItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val mainScreenInteractor: MainScreenInteractor
): ViewModel() {

    private var hotSales: MutableLiveData<List<HotSaleItem>> = MutableLiveData()
    private var bestSellers: MutableLiveData<List<BestSellerItem>> = MutableLiveData()

    private var cartItemCount: MutableLiveData<Int> = MutableLiveData()

    fun observeHotSales(): MutableLiveData<List<HotSaleItem>> = hotSales
    fun observeBestSellers(): MutableLiveData<List<BestSellerItem>> = bestSellers
    fun observeCartItemCount(): MutableLiveData<Int> = cartItemCount

    fun getPhonesData() {
        viewModelScope.launch {
            val phoneListItems = mainScreenInteractor.getHotSaleItems()
            hotSales.value = phoneListItems.hotSales
            bestSellers.value = phoneListItems.bestSellers
        }
    }

    fun getCartItemsCount() {
        viewModelScope.launch {
            val count = mainScreenInteractor.getCartItemsCount()
            cartItemCount.value = count
        }
    }
}