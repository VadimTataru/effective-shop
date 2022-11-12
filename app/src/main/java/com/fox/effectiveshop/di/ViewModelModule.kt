package com.fox.effectiveshop.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fox.core_ui.di.ViewModelKey
import com.fox.feature_details_screen.presentation.viewmodel.DetailsScreenViewModel
import com.fox.effectiveshop.presentation.viewmodel.ViewModelFactory
import com.fox.feature_main_screen.di.MainScreenModule
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(
    includes = [MainScreenModule::class]
)
abstract class ViewModelModule {
    //Factory
    @Binds
    abstract fun bindFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(DetailsScreenViewModel::class)
    abstract fun bindDetailsScreenViewModel(detailsScreenViewModel: DetailsScreenViewModel): ViewModel
}