package com.fox.domain.di

import com.fox.domain.interactor.MainScreenInteractor
import com.fox.domain.repository.MainScreenRepository
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

    @Provides
    fun provideMainScreenInteractor(repository: MainScreenRepository): MainScreenInteractor {
        return MainScreenInteractor(repository)
    }
}