package com.fox.feature_cart_screen.di

import com.fox.core_ui.di.FeatureModuleScope
import dagger.Component

@FeatureModuleScope
@Component(
    dependencies = [CartScreenDeps::class]
)
interface CartScreenComponent {
    @Component.Builder
    interface Builder {
        fun dependency(mainScreenDeps: CartScreenDeps): Builder
        fun build(): CartScreenComponent
    }
}