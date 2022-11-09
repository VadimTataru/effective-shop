package com.fox.data.di

import com.fox.data.repository.DetailsScreenRepositoryImpl
import com.fox.data.repository.MainScreenRepositoryImpl
import com.fox.data.source.remote.PhoneListService
import com.fox.domain.di.DomainDependencies
import com.fox.domain.repository.DetailsScreenRepository
import dagger.Component

@Component(
    modules = [NetworkModule::class]
)
interface DataComponent: DomainDependencies {
    override fun mainScreenRepository(): MainScreenRepositoryImpl
    override fun detailsScreenRepository(): DetailsScreenRepositoryImpl

    fun getPhoneListService(): PhoneListService

    @Component.Builder
    interface Builder {
        fun build(): DataComponent
    }
}