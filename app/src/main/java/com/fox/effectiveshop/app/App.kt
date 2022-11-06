package com.fox.effectiveshop.app

import android.app.Application
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
            .build()

        applicationComponent.inject(this)
    }
}