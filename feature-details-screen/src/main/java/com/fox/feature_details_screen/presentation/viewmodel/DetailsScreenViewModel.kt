package com.fox.feature_details_screen.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fox.feature_details_screen.domain.interactor.DetailsScreenInteractor
import com.fox.feature_details_screen.domain.models.ProductDetailsItem
import com.fox.feature_details_screen.domain.models.ViewPagerShopItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsScreenViewModel @Inject constructor(
    private val interactor: DetailsScreenInteractor
): ViewModel() {

    private var details: MutableLiveData<ProductDetailsItem> = MutableLiveData()
    private var viewPagerShopItem: MutableLiveData<ViewPagerShopItem> = MutableLiveData()
    private var images: MutableLiveData<List<String>> = MutableLiveData()
    private var isFavorite: MutableLiveData<Boolean> = MutableLiveData()

    fun getImages(): MutableLiveData<List<String>> = images
    fun getDetailsInfo(): MutableLiveData<ProductDetailsItem> = details
    fun getViewPagerShopInfo(): MutableLiveData<ViewPagerShopItem> = viewPagerShopItem
    fun getFavoriteState(): MutableLiveData<Boolean> = isFavorite

    fun fakeFavouriteEvent() {
        isFavorite.value = !isFavorite.value!!
    }

    fun getProductDetails() {
        viewModelScope.launch {
            val result = interactor.getProductDetails()
            details.value = result
            images.value = result.images
            isFavorite.value = result.isFavorites
            viewPagerShopItem.value = result.mapToViewPagerShopItem()
        }
    }
}