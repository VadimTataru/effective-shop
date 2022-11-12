package com.fox.effectiveshop.app

import android.app.Application
import com.fox.effectiveshop.di.ApplicationComponent
import com.fox.effectiveshop.di.ApplicationDeps
import com.fox.effectiveshop.di.DaggerApplicationComponent
import com.fox.feature_main_screen.di.DaggerMainScreenComponent
import com.fox.feature_main_screen.di.MainScreenComponent
import com.fox.feature_main_screen.di.MainScreenDeps
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import retrofit2.Retrofit
import javax.inject.Inject

class App: Application(), HasAndroidInjector, ApplicationDeps {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> = androidInjector
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
            .builder()
            .application(this)
            .build()

        applicationComponent.inject(this)
    }

    override val retrofit: Retrofit
        get() = applicationComponent.getRetrofit()
}