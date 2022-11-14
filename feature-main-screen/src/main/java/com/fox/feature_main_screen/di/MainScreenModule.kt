package com.fox.feature_main_screen.di

import androidx.lifecycle.ViewModel
import com.fox.core_ui.di.ViewModelKey
import com.fox.feature_main_screen.data.repository.MainScreenRepositoryImpl
import com.fox.feature_main_screen.data.source.remote.MainScreenService
import com.fox.feature_main_screen.domain.repository.MainScreenRepository
import com.fox.feature_main_screen.presentation.viewmodel.MainScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

@Module
interface MainScreenModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainScreenViewModel::class)
    fun bindMainScreenViewModel(mainScreenViewModel: MainScreenViewModel): ViewModel

    @Binds
    fun provideMainScreenRepository(repository: MainScreenRepositoryImpl): MainScreenRepository

    companion object {
        @Provides
        fun provideMainScreenService(retrofit: Retrofit): MainScreenService {
            return retrofit.create(MainScreenService::class.java)
        }
    }
}