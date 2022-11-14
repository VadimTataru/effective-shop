package com.fox.effectiveshop.di

import android.app.Application
import com.fox.core_ui.di.ApplicationScope
import com.fox.effectiveshop.app.App
import com.fox.feature_main_screen.di.MainScreenComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import retrofit2.Retrofit

@ApplicationScope
@Component(modules = [
    AndroidInjectionModule::class,
    ViewModelModule::class,
    ActivityBindingModule::class,
    FragmentBindingModule::class,
    NetworkModule::class
])
interface ApplicationComponent: AndroidInjector<App> {

    fun getRetrofit(): Retrofit

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }
}