package com.fox.core_ui.presentation

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.fox.core_ui.navigation.NavOptions.navigationOptions

open class BaseFragment: Fragment() {
    open fun navigateTo(
        deepLink: String,
        navOptions: NavOptions? = navigationOptions(),
    ) {
        val request = Uri.parse(deepLink)
        findNavController().navigate(request, navOptions)
    }

    open fun navigateTo(
        fragmentId: Int,
        args: Bundle? = null,
        navOptions: NavOptions? = navigationOptions()
    ) {
        findNavController().navigate(fragmentId, args, navOptions)
    }
}