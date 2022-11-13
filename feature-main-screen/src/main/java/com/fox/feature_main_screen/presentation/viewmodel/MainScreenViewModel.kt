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

    fun getHotSales(): MutableLiveData<List<HotSaleItem>> = hotSales
    fun getBestSellers(): MutableLiveData<List<BestSellerItem>> = bestSellers

    fun getPhonesData() {
        viewModelScope.launch {
            val phoneListItems = mainScreenInteractor.getHotSaleItems()
            hotSales.value = phoneListItems.hotSales
            bestSellers.value = phoneListItems.bestSellers
        }
    }
}