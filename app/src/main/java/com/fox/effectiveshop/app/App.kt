package com.fox.effectiveshop.app

import android.app.Application
import com.fox.data.di.DaggerDataComponent
import com.fox.data.di.DataComponent
import com.fox.domain.di.DaggerDomainComponent
import com.fox.domain.di.DomainComponent
import com.fox.effectiveshop.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App: Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()

        val applicationComponent = DaggerApplicationComponent
            .builder()
            .application(this)
            .dataComponent(provideDataComponent())
            .domainComponent(provideDomainComponent())
            .build()

        applicationComponent.inject(this)
    }

    private fun provideDataComponent(): DataComponent {
        return DaggerDataComponent.builder().build()
    }

    private fun provideDomainComponent(): DomainComponent {
        return DaggerDomainComponent.builder()
            .dependencies(provideDataComponent())
            .build()
    }
}