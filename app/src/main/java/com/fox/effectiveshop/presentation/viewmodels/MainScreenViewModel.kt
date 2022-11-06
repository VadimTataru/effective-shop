package com.fox.effectiveshop.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fox.domain.interactor.MainScreenInteractor
import com.fox.domain.models.BestSellerItem
import com.fox.domain.models.HotSaleItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val mainScreenInteractor: MainScreenInteractor
): ViewModel() {

    private var hotSales: MutableLiveData<List<HotSaleItem>> = MutableLiveData()
    private var bestSellers: MutableLiveData<List<BestSellerItem>> = MutableLiveData()

    fun getPhonesData() {
        viewModelScope.launch {
            val phoneListItems = mainScreenInteractor.getHotSaleItems()
            hotSales.value = phoneListItems.hotSales
            bestSellers.value = phoneListItems.bestSellers
        }
    }
}