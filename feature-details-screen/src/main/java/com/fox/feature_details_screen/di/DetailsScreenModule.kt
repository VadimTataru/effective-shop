package com.fox.feature_details_screen.di

import androidx.lifecycle.ViewModel
import com.fox.core_ui.di.ViewModelKey
import com.fox.feature_details_screen.data.repository.DetailsScreenRepositoryImpl
import com.fox.feature_details_screen.data.source.remote.DetailsScreenService
import com.fox.feature_details_screen.domain.repository.DetailsScreenRepository
import com.fox.feature_details_screen.presentation.viewmodel.DetailsScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

@Module
interface DetailsScreenModule {
    @Binds
    @IntoMap
    @ViewModelKey(DetailsScreenViewModel::class)
    fun bindDetailsScreenViewModel(detailsScreenViewModel: DetailsScreenViewModel): ViewModel

    @Binds
    fun provideMainScreenRepository(repository: DetailsScreenRepositoryImpl): DetailsScreenRepository

    companion object {
        @Provides
        fun provideMainScreenService(retrofit: Retrofit): DetailsScreenService {
            return retrofit.create(DetailsScreenService::class.java)
        }
    }
}