package com.fox.effectiveshop.di

import android.app.Application
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
])
interface ApplicationComponent: AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}