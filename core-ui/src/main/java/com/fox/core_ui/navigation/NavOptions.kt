package com.fox.core_ui.navigation

import androidx.navigation.NavOptions
import com.fox.core_ui.R

object NavOptions {
    fun navigationOptions(): NavOptions {
        return NavOptions.Builder()
            .setExitAnim(R.anim.nav_enter)
            .setEnterAnim(R.anim.nav_exit)
            .setPopExitAnim(R.anim.nav_pop_exit)
            .build()
    }
}