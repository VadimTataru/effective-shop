package com.fox.domain.di

import com.fox.domain.repository.DetailsScreenRepository
import com.fox.domain.repository.MainScreenRepository

interface DomainDependencies {
    fun mainScreenRepository(): MainScreenRepository
    fun detailsScreenRepository(): DetailsScreenRepository
}