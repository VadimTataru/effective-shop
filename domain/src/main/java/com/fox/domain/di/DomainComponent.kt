package com.fox.domain.di

import dagger.Component

@Component
interface DomainComponent {
    @Component.Builder
    interface Builder {
        fun build(): DomainComponent
    }
}