package com.fox.feature_cart_screen.di

import androidx.lifecycle.ViewModel
import com.fox.core_ui.di.ViewModelKey
import com.fox.feature_cart_screen.data.repository.CartScreenRepositoryImpl
import com.fox.feature_cart_screen.data.source.remote.CartScreenService
import com.fox.feature_cart_screen.domain.repository.CartScreenRepository
import com.fox.feature_cart_screen.presentation.viewmodel.CartScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

@Module
interface CartScreenModule {
    @Binds
    @IntoMap
    @ViewModelKey(CartScreenViewModel::class)
    fun bindDetailsScreenViewModel(cartScreenViewModel: CartScreenViewModel): ViewModel

    @Binds
    fun provideMainScreenRepository(repository: CartScreenRepositoryImpl): CartScreenRepository

    companion object {
        @Provides
        fun provideMainScreenService(retrofit: Retrofit): CartScreenService {
            return retrofit.create(CartScreenService::class.java)
        }
    }
}