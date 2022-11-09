package com.fox.domain.di

import com.fox.domain.repository.DetailsScreenRepository
import com.fox.domain.repository.MainScreenRepository
import dagger.Component

@Component(
    modules = [InteractorModule::class],
    dependencies = [DomainDependencies::class]
)
interface DomainComponent {

    fun getMainScreenRepository(): MainScreenRepository
    fun getDetailsScreenRepository(): DetailsScreenRepository

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: DomainDependencies): Builder
        fun build(): DomainComponent
    }
}