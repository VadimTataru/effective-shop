package com.fox.effectiveshop.di

import com.fox.feature_details_screen.presentation.fragments.ProductDetailsFragment
import com.fox.feature_main_screen.presentation.fragments.MainScreenFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {
    @ContributesAndroidInjector
    abstract fun bindMainScreenFragment(): MainScreenFragment

    @ContributesAndroidInjector
    abstract fun bindDetailsScreenFragment(): ProductDetailsFragment
}