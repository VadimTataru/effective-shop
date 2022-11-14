package com.fox.effectiveshop.di

import android.app.Application
import com.fox.data.di.DataComponent
import com.fox.domain.di.DomainComponent
import com.fox.effectiveshop.app.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(modules = [
    AndroidInjectionModule::class,
    ViewModelModule::class,
    ActivityBindingModule::class,
    FragmentBindingModule::class
], dependencies = [
    DomainComponent::class,
    DataComponent::class
])
interface ApplicationComponent: AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun domainComponent(domainComponent: DomainComponent): Builder
        fun dataComponent(dataComponent: DataComponent): Builder
        fun build(): ApplicationComponent
    }
}