package com.fox.feature_details_screen.di

import com.fox.core_ui.di.FeatureModuleScope
import dagger.Component

@FeatureModuleScope
@Component(
    dependencies = [
        DetailsScreenDeps::class
    ]
)
interface DetailsScreenComponent {
    @Component.Builder
    interface Builder {
        fun dependency(mainScreenDeps: DetailsScreenDeps): Builder
        fun build(): DetailsScreenComponent
    }
}