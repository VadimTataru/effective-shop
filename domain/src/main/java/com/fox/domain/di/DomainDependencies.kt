package com.fox.domain.di

import com.fox.domain.repository.MainScreenRepository

interface DomainDependencies {
    fun mainScreenRepository(): MainScreenRepository
}