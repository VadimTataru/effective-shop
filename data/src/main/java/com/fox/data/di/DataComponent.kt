package com.fox.data.di

import com.fox.data.source.remote.PhoneListService
import dagger.Component

@Component(
    modules = [NetworkModule::class]
)
interface DataComponent {
    fun getPhoneListService(): PhoneListService

    @Component.Builder
    interface Builder {
        fun build(): DataComponent
    }
}