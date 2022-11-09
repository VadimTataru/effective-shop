package com.fox.effectiveshop.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fox.effectiveshop.di.annotations.ViewModelKey
import com.fox.effectiveshop.presentation.viewmodels.DetailsScreenViewModel
import com.fox.effectiveshop.presentation.viewmodels.MainScreenViewModel
import com.fox.effectiveshop.presentation.viewmodels.factory.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    //Factory
    @Binds
    internal abstract fun bindFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    //ViewModels
    @Binds
    @IntoMap
    @ViewModelKey(MainScreenViewModel::class)
    internal abstract fun bindMainScreenViewModel(mainScreenViewModel: MainScreenViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsScreenViewModel::class)
    internal abstract fun bindDetailsScreenViewModel(detailsScreenViewModel: DetailsScreenViewModel): ViewModel
}