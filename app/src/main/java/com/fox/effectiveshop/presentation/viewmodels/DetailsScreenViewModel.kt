package com.fox.effectiveshop.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fox.domain.interactor.DetailsScreenInteractor
import com.fox.domain.models.ProductDetailsItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsScreenViewModel @Inject constructor(
    private val interactor: DetailsScreenInteractor
): ViewModel() {

    private var details: MutableLiveData<ProductDetailsItem> = MutableLiveData()
    private var images: MutableLiveData<List<String>> = MutableLiveData()

    fun getImages(): MutableLiveData<List<String>> = images

    fun getProductDetails() {
        viewModelScope.launch {
            val result = interactor.getProductDetails()
            details.value = result
            images.value = result.images
        }
    }
}