package com.fox.effectiveshop.di

import com.fox.effectiveshop.presentation.screens.DetailsFragment
import com.fox.effectiveshop.presentation.screens.MainScreenFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {
    @ContributesAndroidInjector
    abstract fun bindMainScreenFragment(): MainScreenFragment

    @ContributesAndroidInjector
    abstract fun bindDetailsScreenFragment(): DetailsFragment
}