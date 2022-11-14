package com.fox.effectiveshop.di

import androidx.lifecycle.ViewModelProvider
import com.fox.effectiveshop.presentation.viewmodel.ViewModelFactory
import com.fox.feature_cart_screen.di.CartScreenModule
import com.fox.feature_details_screen.di.DetailsScreenModule
import com.fox.feature_main_screen.di.MainScreenModule
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        MainScreenModule::class,
        DetailsScreenModule::class,
        CartScreenModule::class
    ]
)
abstract class ViewModelModule {
    //Factory
    @Binds
    abstract fun bindFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}