package com.fox.feature_main_screen.di

import com.fox.core_ui.di.FeatureModuleScope
import com.fox.feature_main_screen.data.repository.MainScreenRepositoryImpl
import com.fox.feature_main_screen.domain.repository.MainScreenRepository
import dagger.Component

@FeatureModuleScope
@Component(
    dependencies = [
        MainScreenDeps::class
    ]
)
interface MainScreenComponent {

    @Component.Builder
    interface Builder {
        fun dependency(mainScreenDeps: MainScreenDeps): Builder
        fun build(): MainScreenComponent
    }
}